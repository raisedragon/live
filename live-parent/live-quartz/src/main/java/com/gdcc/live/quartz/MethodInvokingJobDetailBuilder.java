/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gdcc.live.quartz;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.support.ArgumentConvertingMethodInvoker;
import org.springframework.scheduling.quartz.JobMethodInvocationFailedException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.MethodInvoker;

/**
 * {@link org.springframework.beans.factory.FactoryBean} that exposes a
 * {@link org.quartz.JobDetail} object which delegates job execution to a
 * specified (static or non-static) method. Avoids the need for implementing
 * a one-line Quartz Job that just invokes an existing service method on a
 * Spring-managed target bean.
 *
 * <p>Inherits common configuration properties from the {@link MethodInvoker}
 * base class, such as {@link #setTargetObject "targetObject"} and
 * {@link #setTargetMethod "targetMethod"}, adding support for lookup of the target
 * bean by name through the {@link #setTargetBeanName "targetBeanName"} property
 * (as alternative to specifying a "targetObject" directly, allowing for
 * non-singleton target objects).
 *
 * <p>Supports both concurrently running jobs and non-currently running
 * jobs through the "concurrent" property. Jobs created by this
 * MethodInvokingJobDetailFactoryBean are by default volatile and durable
 * (according to Quartz terminology).
 *
 * <p><b>NOTE: JobDetails created via this FactoryBean are <i>not</i>
 * serializable and thus not suitable for persistent job stores.</b>
 * You need to implement your own Quartz Job as a thin wrapper for each case
 * where you want a persistent job to delegate to a specific service method.
 *
 * <p>Compatible with Quartz 2.1.4 and higher, as of Spring 4.1.
 *
 * @author Juergen Hoeller
 * @author Alef Arendsen
 * @since 18.02.2004
 * @see #setTargetBeanName
 * @see #setTargetObject
 * @see #setTargetMethod
 * @see #setConcurrent
 */
public class MethodInvokingJobDetailBuilder extends ArgumentConvertingMethodInvoker implements Serializable{

	private String name;

	private String group = Scheduler.DEFAULT_GROUP;
	
	private String description;

	private boolean concurrent = true;

	private String targetBeanName;

	private String beanName;

	private  transient ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

	private BeanFactory beanFactory;

	private JobDetail jobDetail;

	
	public JobDetail build() throws ClassNotFoundException, NoSuchMethodException{
		afterPropertiesSet();
		return jobDetail;
	}
	
	public MethodInvokingJobDetailBuilder	withStaticMethod(String staticMethod){
		super.setStaticMethod(staticMethod);
		return this;
	}
	public MethodInvokingJobDetailBuilder	withTargetClass(Class<?> targetClass){
		super.setTargetClass(targetClass);
		return this;
		
	}
	public MethodInvokingJobDetailBuilder	withTargetMethod(String targetMethod){
		super.setTargetMethod(targetMethod);
		return this;
		
	}
	public MethodInvokingJobDetailBuilder	withTargetObject(Object targetObject){
		super.setTargetObject(targetObject);
		return this;
		
	}

	/**
	 * Set the name of the job.
	 * <p>Default is the bean name of this FactoryBean.
	 */
	public MethodInvokingJobDetailBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the group of the job.
	 * <p>Default is the default group of the Scheduler.
	 * @see org.quartz.Scheduler#DEFAULT_GROUP
	 */
	public MethodInvokingJobDetailBuilder withGroup(String group) {
		this.group = group;
		return this;
	}

	
	
	
	
	public String getDescription() {
		return description;
	}


	public MethodInvokingJobDetailBuilder withDescription(String description) {
		this.description = description;
		return this;
	}


	/**
	 * Specify whether or not multiple jobs should be run in a concurrent fashion.
	 * The behavior when one does not want concurrent jobs to be executed is
	 * realized through adding the {@code @PersistJobDataAfterExecution} and
	 * {@code @DisallowConcurrentExecution} markers.
	 * More information on stateful versus stateless jobs can be found
	 * <a href="http://www.quartz-scheduler.org/documentation/quartz-2.1.x/tutorials/tutorial-lesson-03">here</a>.
	 * <p>The default setting is to run jobs concurrently.
	 */
	public MethodInvokingJobDetailBuilder withConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
		return this;
	}

	/**
	 * Set the name of the target bean in the Spring BeanFactory.
	 * <p>This is an alternative to specifying {@link #setTargetObject "targetObject"},
	 * allowing for non-singleton beans to be invoked. Note that specified
	 * "targetObject" and {@link #setTargetClass "targetClass"} values will
	 * override the corresponding effect of this "targetBeanName" setting
	 * (i.e. statically pre-define the bean type or even the bean object).
	 */
	public MethodInvokingJobDetailBuilder withTargetBeanName(String targetBeanName) {
		this.targetBeanName = targetBeanName;
		return this;
	}


	@Override
	protected Class<?> resolveClassName(String className) throws ClassNotFoundException {
		return ClassUtils.forName(className, this.beanClassLoader);
	}


	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws ClassNotFoundException, NoSuchMethodException {
		prepare();

		// Use specific name if given, else fall back to bean name.
		String name = (this.name != null ? this.name : this.beanName);

		// Consider the concurrent flag to choose between stateful and stateless job.
		Class<?> jobClass = (this.concurrent ? MethodInvokingJob.class : StatefulMethodInvokingJob.class);

		// Build JobDetail instance.
		JobDetailImpl jdi = new JobDetailImpl();
		jdi.setName(name);
		jdi.setGroup(this.group);
		jdi.setJobClass((Class) jobClass);
		jdi.setDurability(true);
		jdi.getJobDataMap().put("methodInvoker", this);
		this.jobDetail = jdi;

		postProcessJobDetail(this.jobDetail);
	}

	/**
	 * Callback for post-processing the JobDetail to be exposed by this FactoryBean.
	 * <p>The default implementation is empty. Can be overridden in subclasses.
	 * @param jobDetail the JobDetail prepared by this FactoryBean
	 */
	protected void postProcessJobDetail(JobDetail jobDetail) {
	}


	/**
	 * Overridden to support the {@link #setTargetBeanName "targetBeanName"} feature.
	 */
	@Override
	public Class<?> getTargetClass() {
		Class<?> targetClass = super.getTargetClass();
		if (targetClass == null && this.targetBeanName != null) {
			Assert.state(this.beanFactory != null, "BeanFactory must be set when using 'targetBeanName'");
			targetClass = this.beanFactory.getType(this.targetBeanName);
		}
		return targetClass;
	}

	/**
	 * Overridden to support the {@link #setTargetBeanName "targetBeanName"} feature.
	 */
	@Override
	public Object getTargetObject() {
		Object targetObject = super.getTargetObject();
		if (targetObject == null && this.targetBeanName != null) {
			Assert.state(this.beanFactory != null, "BeanFactory must be set when using 'targetBeanName'");
			targetObject = this.beanFactory.getBean(this.targetBeanName);
		}
		return targetObject;
	}



	/**
	 * Quartz Job implementation that invokes a specified method.
	 * Automatically applied by MethodInvokingJobDetailFactoryBean.
	 */
	public static class MethodInvokingJob extends QuartzJobBean {

		protected static final Log logger = LogFactory.getLog(MethodInvokingJob.class);

		private MethodInvoker methodInvoker;

		/**
		 * Set the MethodInvoker to use.
		 */
		public void setMethodInvoker(MethodInvoker methodInvoker) {
			this.methodInvoker = methodInvoker;
		}

		/**
		 * Invoke the method via the MethodInvoker.
		 */
		@Override	
		protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
			try {
				context.setResult(this.methodInvoker.invoke());
			}
			catch (InvocationTargetException ex) {
				if (ex.getTargetException() instanceof JobExecutionException) {
					// -> JobExecutionException, to be logged at info level by Quartz
					throw (JobExecutionException) ex.getTargetException();
				}
				else {
					// -> "unhandled exception", to be logged at error level by Quartz
					throw new JobMethodInvocationFailedException(this.methodInvoker, ex.getTargetException());
				}
			}
			catch (Exception ex) {
				// -> "unhandled exception", to be logged at error level by Quartz
				throw new JobMethodInvocationFailedException(this.methodInvoker, ex);
			}
		}
	}


	/**
	 * Extension of the MethodInvokingJob, implementing the StatefulJob interface.
	 * Quartz checks whether or not jobs are stateful and if so,
	 * won't let jobs interfere with each other.
	 */
	@PersistJobDataAfterExecution
	@DisallowConcurrentExecution
	public static class StatefulMethodInvokingJob extends MethodInvokingJob {

		// No implementation, just an addition of the tag interface StatefulJob
		// in order to allow stateful method invoking jobs.
	}

}
