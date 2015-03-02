package com.winit.common.spi.context.support;

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
 * dubbo consumer上下文filter
 * consumer在调用provider时，
 * consumer在发出请求之后，
 * consumer配置此filter拦截请求
 * 把当前线程中的context对象设置到请求command中
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * fu.wan    1.0           2015-1-15     Created
 *
 * </pre>
 * @since 1.
 */
@Activate
public class CommandContextDubboConsumerFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            for (Object arg : invocation.getArguments()) {
                if (arg instanceof SPICommand) {
                    SPICommand spiCommand = (SPICommand) arg;
                    // 设置上下文对象
                    CommandContext ctx = CommandContext.getContext();
                    spiCommand.setCtx(ctx);
                    break;
                }
            }
            return invoker.invoke(invocation);
        } finally {
            RpcContext.getContext().clearAttachments();
        }
    }
}
