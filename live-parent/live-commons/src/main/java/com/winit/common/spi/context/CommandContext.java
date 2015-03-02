package com.winit.common.spi.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.winit.common.context.WinitContext;

/**
 * 命令上下文对象
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     Version       Date        Changes
 * fu.wan    1.0           2014-10-21     Created
 *
 * </pre>
 * @since 1.
 */
public class CommandContext extends WinitContext implements Serializable {

    private static final long serialVersionUID = 3171398407149447237L;
    private static ThreadLocal<CommandContext> context = new ThreadLocal<CommandContext>();
    private Collection<String> ipList = new ArrayList<String>();
    private String requestUrl;


    public CommandContext(){
        //CommandContext.setContext(this);
    }

    /**
     * 设置命令上下文环境到当前线程
     *
     * @param ctx 命令上下文环境
     */
    public static void setContext(CommandContext ctx) {
        CommandContext.context.set(ctx);
    }

    /**
     * 获取当前线程的命令上下文环境
     *
     * @return 返回当前线程的命令上下文环境，如果没有则返回<tt>null</tt>.
     */
    public static CommandContext getContext() {
        CommandContext ctx = context.get();
        if (ctx == null) {
            ctx = new CommandContext();
            CommandContext.setContext(ctx);
        }
        return ctx;
    }

    public void clean() {
        super.clean();
        ipList.clear();
        requestUrl = null;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Collection<String> getIpList(){
    	return this.ipList;
    }
    
    public void addIp(String ip){
    	this.ipList.add(ip);
    }
}
