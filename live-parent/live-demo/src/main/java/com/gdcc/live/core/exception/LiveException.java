package com.gdcc.live.core.exception;

@SuppressWarnings("serial")
public class LiveException extends RuntimeException {

    protected String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LiveException errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public LiveException(){
        super();
    }

    public LiveException(Throwable cause){
        super(cause);
    }

    public LiveException(Throwable cause, String code){
        super(cause);
        this.errorCode = code;
    }

    public LiveException(String message){
        super(message);
    }

    public LiveException(String message, String code){
        super(message);
        this.errorCode = code;
    }

    public LiveException(String message, Throwable cause){
        super(message, cause);
    }

    public LiveException(String message, Throwable cause, String code){
        super(message, cause);
        this.errorCode = code;
    }

}
