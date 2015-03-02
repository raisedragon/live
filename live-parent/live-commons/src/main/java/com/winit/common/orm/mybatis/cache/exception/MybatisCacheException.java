package com.winit.common.orm.mybatis.cache.exception;
/**
 * mybatis-redis二级缓存异常类
 * @author jianke.zhang 2015-1-15 下午4:52:40
 * @since 1.0
 */
public class MybatisCacheException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3445559522873778579L;

    public MybatisCacheException(){
        super();
    }

    public MybatisCacheException(String message){
        super(message);
    }

    public MybatisCacheException(Throwable cause){
        super(cause);
    }

    public MybatisCacheException(String message, Throwable cause){
        super(message, cause);
    }
}
