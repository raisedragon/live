package com.gdcc.live.core.identity;

/**
 * 唯一ID获取类。
 */
public class UniqueIdUtil {

    private static IdGenerator idGenerator;

    public void setIdGenerator(IdGenerator idGen) {
    	UniqueIdUtil.idGenerator = idGen;
    }

    /**
     * 获取long型的ID.
     * 
     * @return Long
     * @exception
     * @since 1.0.0
     */
    public static Long getUId() {
        return idGenerator.getUId();
    }

    /**
     * 获取字符型的ID
     * 
     * @return
     */
    public static String getSuid() {
        return idGenerator.getSuid();
    }
}
