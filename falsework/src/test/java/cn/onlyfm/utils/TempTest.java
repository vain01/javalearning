package cn.onlyfm.utils;

import cn.onlyfm.utils.encryption.AesUtil;
import cn.onlyfm.utils.encryption.Md5Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author haoliang on 2018/7/19.
 */
public class TempTest {
	@Test
	public void testJsonMap() {
		Long ag = Long.valueOf("3");
		System.out.println(ag+1);
	}

	@Test
	public void testArray() {
		List<String> list = new ArrayList<>();
		list.add("89");
		list.add("9");
		list.add("999");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("9")) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}

	@Test
	public void testSign() throws Exception {
		String bizDataQueryString = "mobile=17717550338";
		System.out.println(bizDataQueryString);
		// String key = PropertiesUtil.getProperty(ConfigKeys.PPDAI_KEY);
		String key = "33157460050c5a4df6299dbcffb0ebd0";
		// System.out.println(key);
		String md5Hash = Md5Util.md5(bizDataQueryString, key).toUpperCase();
		System.out.println(md5Hash);
	}

	@Test
	public void testInput() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("mobile", "17717550338");
		System.out.println(param);
		String actualContent = JsonUtil.map2JsonStr(param);
		System.out.println(actualContent);
		// String key = PropertiesUtil.getProperty(ConfigKeys.PPDAI_KEY);
		String key = "33157460050c5a4df6299dbcffb0ebd0";
		String md5Key = Md5Util.md5(key).toUpperCase();
		String aesPwd = md5Key.substring(0, 16);
		String encryptedContent = AesUtil.aesEncrypt(actualContent, aesPwd);
		System.out.println(encryptedContent);
		String base64EncodedString = Base64.getEncoder().encodeToString(encryptedContent.getBytes());
		System.out.println(base64EncodedString);

		String base64DecodedString = new String(Base64.getDecoder().decode(base64EncodedString));
		System.out.println(base64DecodedString);
		String decryptedContent = AesUtil.aesDecrypt(base64DecodedString, aesPwd);
		System.out.println(decryptedContent);
	}

	@Test
	public void test() {
		String bizData = "{\"mobile\":\"17717550338\"}";
		JSONObject jsonObject = JSON.parseObject(bizData);
		String mobile = jsonObject.getString("mobile");
		String keyStr = jsonObject.getString("key");
		System.out.println(keyStr);
		System.out.println(StringUtils.isBlank(keyStr));
		Object key = jsonObject.get("key");
		System.out.println(mobile);
		System.out.println(key);
	}
}
