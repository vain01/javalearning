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
			}
			else {
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

	public static boolean doesContainEmoj(String para) {
		String pattern = ".*(\\\\x[A-Za-z0-9]{2}){4}.*";
		return para.matches(pattern);
	}

	public static boolean containsEmoji(String source) {
		int len = source.length();
		boolean isEmoji = false;
		for (int i = 0; i < len; i++) {
			char hs = source.charAt(i);
			if (0xd800 <= hs && hs <= 0xdbff) {
				if (source.length() > 1) {
					char ls = source.charAt(i + 1);
					int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
					if (0x1d000 <= uc && uc <= 0x1f77f) {
						return true;
					}
				}
			}
			else {
				// non surrogate
				if (0x2100 <= hs && hs <= 0x27ff && hs != 0x263b) {
					return true;
				}
				else if (0x2B05 <= hs && hs <= 0x2b07) {
					return true;
				}
				else if (0x2934 <= hs && hs <= 0x2935) {
					return true;
				}
				else if (0x3297 <= hs && hs <= 0x3299) {
					return true;
				}
				else if (hs == 0xa9 || hs == 0xae || hs == 0x303d
						|| hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c
						|| hs == 0x2b1b || hs == 0x2b50 || hs == 0x231a) {
					return true;
				}
				if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
					char ls = source.charAt(i + 1);
					if (ls == 0x20e3) {
						return true;
					}
				}
			}
		}
		return isEmoji;
	}

	private static boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
				|| (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
				|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	/**
	 * 过滤emoji 或者 其他非文字类型的字符
	 *
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		if (StringUtils.isBlank(source)) {
			return source;
		}
		StringBuilder buf = null;
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}
				buf.append(codePoint);
			}
		}
		if (buf == null) {
			return source;
		}
		else {
			if (buf.length() == len) {
				buf = null;
				return source;
			}
			else {
				return buf.toString();
			}
		}
	}
}
