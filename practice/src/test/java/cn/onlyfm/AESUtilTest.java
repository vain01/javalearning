package cn.onlyfm;

import cn.onlyfm.utils.AESUtil;
import cn.onlyfm.utils.Base64Utils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/4/3.
 */
public class AESUtilTest {
	@Test
	public void testName() throws Exception {
		String content = "{\\\"card_no\\\":\\\"6212261001030909490\\\",\\\"bank_code\\\":\\\"ICBC\\\",\\\"user_name\\\":\\\"\\\\u5360\\\\u5de7\\\\u96ef\\\",\\\"id_card\\\":\\\"360222199304265625\\\",\\\"bank_mobile\\\":\\\"17701618212\\\",\\\"user_mobile\\\":\\\"17701618212\\\",\\\"verify_code\\\":\\\"\\\",\\\"order_no\\\":\\\"RYT1904031451528397\\\"}";
		System.out.println(content);
		String unescapedContent = StringEscapeUtils.unescapeJava(content);
		System.out.println(unescapedContent);
		System.out.println();

		String key = "PLK:~OLWKS8*{tli";
		String iv = "D8jOJDNWLSx*FOQX";

		String encryptedContent = new String(Base64Utils.encode(AESUtil.encrypt(unescapedContent.getBytes(), key.getBytes(), iv.getBytes())));
		System.out.println(encryptedContent);

		String targetStr = "iKWD2RquBID9st142aOOWX165s80yWIe/puUYkcWB30DnXHoOqEHsKoMfHl+DWBp0tFd4dwM2om00Mqk/2CvkxBqsfJlmk8rp24fdhlR6ebn4HGWtFek2FjNOSyKXpsj+L/GK8uPP3nqRllGYnMlUhw2kz2tSfqfgzEdQrY0zHyQEfZYyMYXaEcMGqLNeo2WbF54jkBqHsXI80L7dsHmw7syvvJFPemE1qI22sQHLoZ/gVjNokAyTnW+318E+K1rpuBg5jItI6sE2SzOjSewlb8dOT9HooTGatvlMXPuJOo=";
		System.out.println(targetStr);
		Assert.assertEquals(encryptedContent, targetStr);

		String decryptedStr = AESUtil.decrypt(Base64Utils.decode(targetStr), key, iv);
		System.out.println(decryptedStr);
	}

	/**
	 * 新浪帮帮专用
	 */
	@Test
	public void testSinaBangBangEncrypt() {
		String key = "PLK:~OLWKS8*{tli";
		String iv = "D8jOJDNWLSx*FOQX";

		String channel = "";
		String content = "{\\\"card_no\\\":\\\"6212261001030909490\\\",\\\"bank_code\\\":\\\"ICBC\\\",\\\"user_name\\\":\\\"\\\\u5360\\\\u5de7\\\\u96ef\\\",\\\"id_card\\\":\\\"360222199304265625\\\",\\\"bank_mobile\\\":\\\"17701618212\\\",\\\"user_mobile\\\":\\\"17701618212\\\",\\\"verify_code\\\":\\\"\\\",\\\"order_no\\\":\\\"RYT1904031451528397\\\"}";
		System.out.println(content);
		String unescapedContent = StringEscapeUtils.unescapeJava(content);
		System.out.println(unescapedContent);
		String encryptedContent = new String(Base64Utils.encode(AESUtil.encrypt(unescapedContent.getBytes(), key.getBytes(), iv.getBytes())));
		System.out.println(encryptedContent);

		JSONObject ret = new JSONObject();
		ret.put("data", encryptedContent);
		ret.put("channel", channel);
		System.out.println(ret.toJSONString());
		System.out.println("curl -i -X POST 'http://yxb-alpha-001:8080/yhb/sina/base' -H 'Content-Type: application/json' -d'" + ret.toJSONString() + "'");
	}
}
