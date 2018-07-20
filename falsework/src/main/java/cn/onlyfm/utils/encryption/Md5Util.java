package cn.onlyfm.utils.encryption;

import cn.onlyfm.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * @author haoliang on 2018/5/18.
 */
public class Md5Util {
	public static final String CHARSET_UTF8 = "UTF-8";
	private static final String ALGORITHM = "MD5";

	/**
	 * MD5加密
	 *
	 * @param content 待加密内容
	 * @return 16进制字符串
	 */
	public static String md5(String content) throws Exception {
		return md5Hex(content, Md5Util.CHARSET_UTF8);
	}

	public static String md5(String content, String salt) throws Exception {
		return md5Hex(content + salt, Md5Util.CHARSET_UTF8);
	}

	/**
	 * MD5加密
	 *
	 * @param content 待加密内容
	 * @param charset
	 * @return 16进制字符串
	 * @throws Exception
	 */
	public static String md5Hex(String content, String charset) throws Exception {
		if (content == null) return null;
		if (StringUtils.isBlank(charset)) charset = Md5Util.CHARSET_UTF8;

		try {
			MessageDigest md5 = MessageDigest.getInstance(Md5Util.ALGORITHM);
			// 使用指定的 byte 数组更新摘要
			md5.update(content.getBytes(charset));
			// 通过执行诸如填充之类的最终操作完成哈希计算
			byte[] digest = md5.digest();
			// 转换成16进制字符串
			return StringUtil.bytes2HexString(digest);
		} catch (Exception e) {
			throw new Exception("MD5加密发生错误", e);
		}
	}
}
