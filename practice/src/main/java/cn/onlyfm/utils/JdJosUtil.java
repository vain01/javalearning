package cn.onlyfm.utils;

import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author haoliang on 2019/3/8.
 */
public class JdJosUtil {

	public static String md5(String source)
			throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(source.getBytes("utf-8"));
		return byte2hex(bytes);
	}

	private static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}

	public static boolean areNotEmpty(String[] values) {
		boolean result = true;
		if ((values == null) || (values.length == 0)) {
			result = false;
		}
		else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}

	public static boolean isEmpty(String value) {
		int strLen;
		if ((value == null) || ((strLen = value.length()) == 0)) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 签名代码
	 *
	 * @param timestamp
	 * @param version
	 * @param method
	 * @param paramJson
	 * @param accessToken
	 * @param appKey
	 * @param appSecret
	 * @return
	 * @throws Exception
	 */
	public static String buildSign(String timestamp, String version, String method, String paramJson, String accessToken, String appKey, String appSecret) throws Exception {
		//第一步，按照顺序填充参数
		Map<String, String> map = new TreeMap();
		map.put("360buy_param_json", paramJson);
		map.put("access_token", accessToken);
		map.put("app_key", appKey);
		map.put("method", method);
		map.put("timestamp", timestamp);
		map.put("v", version);
		StringBuilder sb = new StringBuilder(appSecret);
		//sb.append(appSecret);
		//按照规则拼成字符串
		for (Map.Entry entry : map.entrySet()) {
			String name = (String) entry.getKey();
			String value = (String) entry.getValue();
			//检测参数是否为空
			if (areNotEmpty(new String[]{name, value})) {
				sb.append(name).append(value);
			}
		}
		sb.append(appSecret);
		//MD5
		return md5(sb.toString());
	}
}
