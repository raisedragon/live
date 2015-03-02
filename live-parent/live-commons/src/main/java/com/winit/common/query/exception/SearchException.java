package com.winit.common.query.exception;

import com.winit.common.error.WinitException;

/**
 * 搜索异常
 */
public class SearchException extends WinitException {
    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
