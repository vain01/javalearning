package cn.onlyfm.utils.encoding;

import java.util.Base64;

/**
 * @author haoliang on 2018/5/15.
 */
public class Base64Util {

	/**
	 * base64编码
	 *
	 * @param text 待编码的文本明文
	 * @return 字节数组
	 */
	public static byte[] encode2Bytes(String text) {
		return Base64.getEncoder().encode(text.getBytes());
	}

	/**
	 * base64编码
	 *
	 * @param content 待编码的文本明文
	 * @return 字符串
	 */
	public static String encode2String(String content) {
		return new String(encode2Bytes(content));
	}

	/**
	 * base64解码
	 *
	 * @param encodedContent 已编码的文本
	 * @return 字节数组
	 */
	public static byte[] decode2Bytes(String encodedContent) {
		return Base64.getDecoder().decode(encodedContent);
	}

	/**
	 * base64解码
	 *
	 * @param encodedText 已编码的文本
	 * @return 字符串
	 */
	public static String decode2String(String encodedText) {
		return new String(decode2Bytes(encodedText));
	}
}
