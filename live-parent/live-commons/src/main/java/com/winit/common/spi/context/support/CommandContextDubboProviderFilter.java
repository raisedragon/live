package com.winit.common.spi.context.support;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.winit.common.spi.command.SPICommand;
import com.winit.common.spi.context.CommandContext;

/**
 * dubbo provider上下文filter consumer在调用provider时， 在请求到达provider时，
 * provider配置此filter拦截请求， 把请求参数中的源context设置到当前线程中，保证递归向下传递context
 * 
 * @version Revision History
 * 
 *          <pre>
 * Author     Version       Date        Changes
 * fu.wan    1.0           2015-1-15     Created
 * 
 * </pre>
 * @since 1.
 */
@Activate
public class CommandContextDubboProviderFilter implements Filter {

	/**
	 * 日志记录对象
	 */
	private Logger logger = LoggerFactory
			.getLogger(CommandContextDubboProviderFilter.class);

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		try {
			for (Object arg : invocation.getArguments()) {
				if (arg instanceof SPICommand) {
					//获取CommandContext
					SPICommand spiCommand = (SPICommand) arg;
					CommandContext commandContext = spiCommand.getCtx();
					if (null == commandContext) {
                        commandContext = CommandContext.getContext();
                        spiCommand.setCtx(commandContext);

                    }
                    //把当前机器的ip添加到CommandContext
                    String ip = null;
                    try {
                        // 获得本机IP
                        InetAddress addr = InetAddress.getLocalHost();
                        ip = addr.getHostAddress().toString();
                    } catch (UnknownHostException e) {
                        logger.warn("get ip error:" + e);
                    }
					if (null != ip) {
                        commandContext.addIp(ip);
					}

                    // 初始化threadLocal
                    CommandContext.setContext(commandContext);
					break;
				}
			}
			return invoker.invoke(invocation);
		} finally {
			RpcContext.getContext().clearAttachments();
		}
	}
}
