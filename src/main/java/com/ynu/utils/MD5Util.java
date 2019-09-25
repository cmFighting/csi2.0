package com.ynu.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String md5(String rawPassword){
        String key = "员工之家";
        String encodeStr= DigestUtils.md5Hex(rawPassword+key);
        return encodeStr;
    }

    public static boolean verify(String rawPassword, String rightPassword){
        String md5Text = md5(rawPassword);
        if(md5Text.equalsIgnoreCase(rightPassword))
            return true;
        else
            return false;
    }
}
