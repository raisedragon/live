package com.gdcc.live.system.entity;

/**
 * 邮件发送状态
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     Version       Date        Changes
 * kaizhou.chen    1.0           2015-01-12     Created
 * 
 * </pre>
 * @since 1.
 */
public enum MailStatus {
    /** 等待发送 */
    WS,
    /** 发送完成 */
    SC;

    public String value() {
        return name();
    }

    public static MailStatus fromValue(String v) {
        return valueOf(v);
    }
}
