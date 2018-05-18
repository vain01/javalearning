package cn.onlyfm.utils.encryption;

import cn.onlyfm.utils.StringUtil;

import java.security.MessageDigest;

/**
 * @author haoliang on 2018/5/18.
 */
public class Md5Util {
	public static final String CHARSET_UTF8 = "UTF-8";
	private static final String ALGORITHM = "MD5";

	public static String MD5(String content) {
		try {
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
			// 使用指定的 byte 数组更新摘要
			md5.update(content.getBytes(CHARSET_UTF8));
			// 通过执行诸如填充之类的最终操作完成哈希计算
			byte[] digest = md5.digest();
			// 转换成16进制字符串
			return StringUtil.byte2Hex(digest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
