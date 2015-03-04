package com.gdcc.live.system.entity;

public final class ConfigConst {

    /**
     * 系统版本号
     */
    public static final String KEY_SYSTEM_VERSION            = "SYSTEM_VERSION";
    /**
     * 系统代码
     */
    public static final String KEY_SYSTEM_CODE               = "SYSTEM_CODE";
    /**
     * 系统国家代码
     */
    public static final String KEY_SYSTEM_COUNTRY_CODE       = "SYSTEM_COUNTRY_CODE";
    /**
     * 面单存放目录
     */
    public static final String KEY_LABEL_STORE_BASE_PATH     = "LABEL_STORE_BASE_PATH";
    /**
     * 发货单存放目录
     */
    public static final String KEY_MANIFEST_STORE_BASE_PATH  = "MANIFEST_STORE_BASE_PATH";
    /**
     * 预报存放目录
     */
    public static final String KEY_PREADVICE_STORE_BASE_PATH = "PREADVICE_STORE_BASE_PATH";

    /**
     * Get Label 超时时长
     */
    public static final String KEY_GET_LABEL_TIMEOUT         = "GET_LABEL_TIMEOUT";

    private ConfigConst(){
    };
}
