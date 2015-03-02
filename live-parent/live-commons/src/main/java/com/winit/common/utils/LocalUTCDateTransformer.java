package com.winit.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * 本地&UTC日期变化器
 * <p/>
 * Created by liuye on 2015/1/27.
 */
public class LocalUTCDateTransformer {

	public static void transform(Object object, Direction direction) {
		if (object == null) {
			return;
		}
		Class<?> clazz = object.getClass();
		if (!isSimpleType(clazz)) {
			if (clazz.isArray()) {
				for (Object obj : (Object[]) object) {
					if (needTransformed(obj)) {
						transform(obj, direction);
					}
				}
				return;
			}
			
			if (Collections3.isCollectionType(clazz)) {
				for (Object obj : (Collection<?>) object) {
					if (needTransformed(obj)) {
						transform(obj, direction);
					}
				}
				return;
			}
			
			if (Collections3.isMapType(clazz)) {
				for (Map.Entry<?, ?> entry : ((Map<?, ?>) object).entrySet()) {
					Object obj = entry.getValue();
					if (needTransformed(obj)) {
						transform(obj, direction);
					}
				}
				return;
			}
			
			PropertyDescriptor[] descriptors = BeanUtils
					.getPropertyDescriptors(clazz);
			for (PropertyDescriptor descriptor : descriptors) {
				Class<?> propertyType = descriptor.getPropertyType();
				Method readMethod = descriptor.getReadMethod();
				if (readMethod != null) {
					try {
						if (!Modifier.isPublic(readMethod.getDeclaringClass()
								.getModifiers())) {
							readMethod.setAccessible(true);
						}
						
						if (isDateType(propertyType)) {
							Object value = readMethod.invoke(object);
							if (value != null) {
								if (Direction.TO_UTC.equals(direction)) {
									Dates.toUTCDate((Date) value);
								} else {
									Dates.toLocalDate((Date) value);
								}
							}
						} else if (!isSimpleType(propertyType)) {
							Object value = readMethod.invoke(object);
							transform(value, direction);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException(
								"Could not copy property '"
										+ descriptor.getName()
										+ "' from source to target", ex);
					}
				}
			}
		} else if (isDateType(object)) {
			if (Direction.TO_UTC.equals(direction)) {
				Dates.toUTCDate((Date) object);
			} else {
				Dates.toLocalDate((Date) object);
			}
		}
	}

	public static enum Direction {
		TO_UTC, TO_LOCAL
	}

	public static boolean needTransformed(Object obj){
		return obj != null && (!isSimpleType(obj) || isDateType(obj));
	}
	
	public static boolean isDateType(Object object) {
		return isDateType(object.getClass());
	}

	public static boolean isDateType(Class<?> clazz) {
		return Date.class.isAssignableFrom(clazz);
	}

	public static boolean isSimpleType(Object object) {
		Assert.notNull(object, "Object must not be null");
		return isSimpleType(object.getClass());
	}

	public static boolean isSimpleType(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return ClassUtils.isPrimitiveOrWrapper(clazz) || clazz.isEnum()
				|| CharSequence.class.isAssignableFrom(clazz)
				|| Number.class.isAssignableFrom(clazz)
				|| Date.class.isAssignableFrom(clazz)
				|| Calendar.class.isAssignableFrom(clazz)
				|| clazz.equals(URI.class) || clazz.equals(URL.class)
				|| clazz.equals(Locale.class) || clazz.equals(Class.class);
	}
}
