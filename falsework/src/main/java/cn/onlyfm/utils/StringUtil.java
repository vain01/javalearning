package cn.onlyfm.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author haoliang on 2018/5/14.
 */

public class StringUtil {
	public static final int RADIX_HEX = 16;

	/**
	 * 将字符串设置掩码（把部分字符设成*号，信息脱敏）
	 *
	 * @param str
	 * @param prefixRetain 前置保留位
	 * @param suffixRetain 后置保留位
	 * @return
	 */
	public static String setMask(String str, int prefixRetain, int suffixRetain) {
		// 验空
		if (StringUtils.isBlank(str)) return "";

		// 保留位长度检查
		prefixRetain = prefixRetain < 0 ? 0 : prefixRetain;
		suffixRetain = suffixRetain < 0 ? 0 : suffixRetain;
		if (prefixRetain >= str.length() || suffixRetain >= str.length() || prefixRetain + suffixRetain >= str.length()) return str;

		// 截取保留位
		String prefixStr = str.substring(0, prefixRetain);
		String suffixStr = str.substring(str.length() - suffixRetain, str.length());

		StringBuilder returnStr = new StringBuilder();
		// 前保留位填充
		returnStr.append(prefixStr);
		// 掩码填充
		for (int i = 0; i < str.length() - prefixRetain - suffixRetain; i++) returnStr.append("*");
		// 后保留位填充
		returnStr.append(suffixStr);

		return returnStr.toString();
	}

	/**
	 * 将byte数组转换成16进制字符串
	 *
	 * @param srcBytes 待转换的byte数组
	 * @return
	 */
	public static String byte2Hex(byte[] srcBytes) {
		StringBuilder hexRetSB = new StringBuilder();
		for (byte b : srcBytes) {
			String hexString = Integer.toHexString(0xff & b);
			// 补全1位的16进制字符串
			hexRetSB.append(hexString.length() == 1 ? "0" : "").append(hexString);
		}
		return hexRetSB.toString();
	}

	/**
	 * 将16进制字符串转为转换成byte数组
	 *
	 * @param source
	 * @return
	 */
	public static byte[] hex2Bytes(String source) {
		// 每两个16进制字符组成一个字节
		byte[] sourceBytes = new byte[source.length() / 2];
		for (int i = 0; i < sourceBytes.length; i++) {
			// 每两个取值，并按16进制转成int型，然后转成字节
			sourceBytes[i] = (byte) Integer.parseInt(source.substring(i * 2, i * 2 + 2), RADIX_HEX);
		}
		return sourceBytes;
	}
}
