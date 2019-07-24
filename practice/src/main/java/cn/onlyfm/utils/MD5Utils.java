package cn.onlyfm.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * @author haoliang on 2019/3/6.
 */
public class MD5Utils {
	public static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

	public MD5Utils() {
	}

	public static String generatePassword(String inputString) {
		return encodeByMD5(inputString);
	}

	public static boolean validatePassword(String password, String inputString) {
		return StringUtils.equals(password.trim(), encodeByMD5(inputString).trim());
	}

	public static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes("utf-8"));
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception var4) {
				var4.printStackTrace();
			}
		}

		return null;
	}

	public static String encodeByMD5(String originString, int upper) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes("utf-8"));
				String resultString = byteArrayToHexString(results);
				if (0 == upper) {
					return resultString;
				}

				return resultString.toUpperCase();
			} catch (Exception var5) {
				var5.printStackTrace();
			}
		}

		return null;
	}

	public static String encodeByMD5Salt(String originString, String salt) {
		if (originString != null) {
			StringBuffer sb = new StringBuffer(originString);
			sb.append(salt);

			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(sb.toString().getBytes("utf-8"));
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception var6) {
				var6.printStackTrace();
			}
		}

		return null;
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();

		for(int i = 0; i < b.length; ++i) {
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	public static String byteToHexString(byte b) {
		int n = b;
		if (b < 0) {
			n = 256 + b;
		}

		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
