package com.winit.common.spi.context.support;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.winit.common.spi.context.CommandContext;
import com.winit.common.utils.Dates;

/**
 * context上下文初始化filter
 * openApi，openrationPortal 初始化filter
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
public class CommandContextServletFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException,
                                                                                            ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) arg0;
            //上下文对象
            CommandContext ctx = CommandContext.getContext();
            //设置流水号
            ctx.setSequence(getSerialNumber());
            
            //保存ip
            String localHost = request.getLocalAddr();
            String remoteHost = request.getRemoteAddr();
            ctx.addIp(remoteHost);
            ctx.addIp(localHost);
            
            //保存请求路径
            String requestURI = request.getRequestURL().toString();
            ctx.setRequestUrl(requestURI);
            
            //设置时区
            //ctx.setTimeZone(TimeZone.getDefault());
        } finally {
            filterChain.doFilter(arg0, arg1);
            CommandContext.getContext().clean();
        }
    }
    
    public String getSerialNumber(){
        String no = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowdate = sdf.format(Dates.getLocalDate(new Date()));
        no += Long.parseLong(nowdate)*1000;
        return no;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
