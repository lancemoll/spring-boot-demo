package com.xkcoding.sharding.jdbc.utils;

import com.google.common.hash.Hashing;
import org.apache.commons.lang.StringUtils;

public final class MD5Utils {
    private MD5Utils() {
    }

    public static String encode16(String source) {
        return StringUtils.isBlank(source) ? "" : encode32(source).substring(8, 24);
    }

    public static String encode16Long(Long source) {
        return encode16(source == null ? null : source.toString());
    }

    public static String encode32(String source) {
        return StringUtils.isBlank(source) ? source : Hashing.md5().hashBytes(source.getBytes()).toString();
    }
}
