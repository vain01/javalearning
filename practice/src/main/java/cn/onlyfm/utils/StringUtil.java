package cn.onlyfm.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * author : zhangling@herobt.com
 * created date : 18-3-6
 */

public final class StringUtil {


    /**
     * 将字符串转换为*号
     *
     * @param str
     * @param prefixRetain 前置保留位
     * @param suffixRetain 后置保留位
     * @return
     */
    public static String setMask(String str, int prefixRetain, int suffixRetain) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        prefixRetain = prefixRetain < 0 ? 0 : prefixRetain;
        suffixRetain = suffixRetain < 0 ? 0 : suffixRetain;
        StringBuilder returnStr = new StringBuilder();

        if (prefixRetain >= str.length() || suffixRetain >= str.length() || prefixRetain + suffixRetain >= str.length()) {
            return str;
        }
        String prefixStr = "";
        String suffixStr = "";
        if (prefixRetain > 0) {
            prefixStr = str.substring(0, prefixRetain);
        }
        if (suffixRetain > 0) {
            suffixStr = str.substring(str.length() - suffixRetain, str.length());
        }
        returnStr.append(prefixStr);
        for (int i = 0; i < str.length() - prefixRetain - suffixRetain; i++) {
            returnStr.append("*");
        }
        returnStr.append(suffixStr);
        return returnStr.toString();
    }

    public static void main(String[] args) {
//        System.out.println(setMask("6222023202038305941", -1, -1));
//        System.out.println(setMask("6222023202038305941", 0, 0));
//        System.out.println(setMask("6222023202038305941", 4, 14));
//        System.out.println(setMask("6222023202038305941", 4, 17));
//        System.out.println(setMask("6222023202038305941", 4, 4));
    }


    /**
     * 在url后面拼接查询串
     *
     * @param url
     * @param param
     * @return
     */
    public static String contactQueryString(String url, String param) {
        if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(param)) {
            if (url.contains("?")) {
                url = url + "&" + param;
            } else {
                url = url + "?" + param;
            }
        }
        return url;
    }

    public static String getProperLengthString(String originStr, int EXPECTED_MAX_LENGTH) {
        String ret = StringUtils.EMPTY;
        if (StringUtils.isNotBlank(originStr)) {
            int strMaxLen = Math.min(originStr.length(), EXPECTED_MAX_LENGTH);
            ret = originStr.substring(0, strMaxLen);
        }
        
        return ret;
    }
}
