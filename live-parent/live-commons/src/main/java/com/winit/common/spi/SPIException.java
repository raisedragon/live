package com.winit.common.spi;

import java.util.Locale;

import com.winit.common.error.LocaleException;
import com.winit.common.spi.context.CommandContext;

/**
 * 服务异常
 */
public class SPIException extends LocaleException {

    public SPIException(Locale locale, String errorCode, Object... params){
        super(locale, errorCode, params);
    }

    public SPIException(String errorCode, Locale locale){
        super(errorCode, locale);
    }

    public SPIException(String errorCode){
        super(errorCode);
    }

    public SPIException(){

    }

    private CommandContext context;

    public CommandContext getContext() {
        return context;
    }

    public void setContext(CommandContext context) {
        this.context = context;
    }

}
