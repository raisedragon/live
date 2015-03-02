package com.winit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取版本号工具类
 */
public final class Versions {
    private Versions() {}

    private static final Logger logger = LoggerFactory.getLogger(Versions.class);

    private static final Pattern VERSION_PATTERN = Pattern.compile("([0-9][0-9\\.\\-]*)\\.jar");


    /**
     * 获取版本号
     * @param clazz
     * @param defaultVersion
     * @return
     */
    public static String getVersion(Class clazz, String defaultVersion) {
        try {
            // 首先查找MANIFEST.MF规范中的版本号
            String version = clazz.getPackage().getImplementationVersion();
            if (version == null || version.length() == 0) {
                version = clazz.getPackage().getSpecificationVersion();
            }
            if (version == null || version.length() == 0) {
                // 如果MANIFEST.MF规范中没有版本号，基于jar包名获取版本号
                String file = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
                if (file != null && file.length() > 0 && file.endsWith(".jar")) {
                    Matcher matcher = VERSION_PATTERN.matcher(file);
                    while (matcher.find() && matcher.groupCount() > 0) {
                        version = matcher.group(1);
                    }
                }
            }
            // 返回版本号，如果为空返回缺省版本号
            return version == null || version.length() == 0 ? defaultVersion : version;
        } catch (Throwable e) { // 防御性容错
            // 忽略异常，返回缺省版本号
            logger.error(e.getMessage(), e);
            return defaultVersion;
        }
    }
}
