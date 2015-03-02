package com.winit.common.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

/**
 * Created by Liuye on 2014/9/22.
 */
public class SpringMessageLocator implements MessageSourceAware {
    private static MessageSource messageSource;

    public static String getMessage(String code){
        return messageSource.getMessage(code,null,null,null);
    }
    public static String getMessage(String code, Locale locale){
        return messageSource.getMessage(code,null,null,locale);
    }

    public static String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException{
        return messageSource.getMessage(code,args,locale);
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale){
        return messageSource.getMessage(code,args,defaultMessage,locale);
    }



    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException{
        return messageSource.getMessage(resolvable,locale);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        SpringMessageLocator.messageSource=messageSource;
    }
}
