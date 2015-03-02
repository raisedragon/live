package com.winit.common.spi.support;

import com.alibaba.dubbo.rpc.*;
import com.winit.common.utils.LocalUTCDateTransformer;

/**
 * Created by liuye on 2015/1/27.
 */
public class LocalUTCDateTransformDubboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            for (Object arg : invocation.getArguments()) {
                if(arg!=null) {
                    LocalUTCDateTransformer.transform(arg, LocalUTCDateTransformer.Direction.TO_UTC);
                }
            }
            Result result=invoker.invoke(invocation);
            processResult(result);
            return result;
        } finally {
            RpcContext.getContext().clearAttachments();
        }
    }

    protected void processResult(Result result){
        LocalUTCDateTransformer.transform(result.getValue(), LocalUTCDateTransformer.Direction.TO_LOCAL);
    }
}