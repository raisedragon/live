package com.winit.common.error;

import java.util.Locale;

import com.winit.common.spring.SpringMessageLocator;

/**
 * 国际化的异常类 Created by Liuye on 2014/9/25.
 */
public class LocaleException extends WinitException {

    private static final long serialVersionUID = 8722378154776002760L;

    private Locale            locale;
    private String            errorCode;
    private String            errorMsg;

    // 对应多个提示信息
    private Object[]          params           = null;

    public LocaleException(){

    }

    public LocaleException(String errorCode){
        this(errorCode, Locale.ENGLISH);
    }

    public LocaleException(String errorCode, Locale locale){
        this(locale, errorCode);
    }

    public LocaleException(Locale locale, String errorCode, Object... params){
        super(errorCode);
        this.locale = locale;
        this.errorCode = errorCode;
        this.params = params;
        errorMsg = this.getLocalizedMessage(locale, errorCode, params);
    }

    @Override
    public String getLocalizedMessage() {
        return getLocalizedMessage(this.locale, this.errorCode, this.params);
    }

    protected String getLocalizedMessage(Locale locale, String errorCode, Object[] params) {
        return SpringMessageLocator.getMessage(errorCode, this.params, null, locale);
    }

    /**
     * @return the errorCode
     */
    @Override
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

}
