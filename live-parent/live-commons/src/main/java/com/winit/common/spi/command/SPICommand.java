package com.winit.common.spi.command;

import java.io.Serializable;

import com.winit.common.spi.context.CommandContext;


/**
 * 服务命令
 * 
 * @author yu.zhang
 * 
 */
public class SPICommand implements Serializable {
    private static final long serialVersionUID = -3383571214350819202L;
    
    private CommandContext ctx;

    public SPICommand(){}
    
    public CommandContext getCtx() {
        return ctx;	
    }


    public void setCtx(CommandContext ctx) {
        this.ctx = ctx;
    }
}
