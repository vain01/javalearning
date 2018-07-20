package cn.onlyfm.utils;

import cn.onlyfm.utils.encryption.Md5Util;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/7/6.
 */
public class JsonUtilTest {

	@Test
	public void testMap2JsonStr() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("billNo", "asddwfxxxy");
		params.put("payBillNo", "asdf");
		params.put("type", 2);
		params.put("amount", 3);
		params.put("idCard", "410423199002286414");
		params.put("name", "扬言无");
		params.put("phone", "17717550328");
		params.put("orderAmount", 2);

		System.out.println(params);

		String jsonStr = JsonUtil.map2JsonStr(params);
		System.out.println(jsonStr);

		String key = "3dde90d47193eaaa5a84e040226f89f4";
		String merchantNo = "miaobt";
		StringBuffer sb = new StringBuffer();
		sb.append(merchantNo);
		sb.append(key);
		sb.append(jsonStr);
		sb.append(key);

		System.out.println(Md5Util.md5(sb.toString()));
	}

	@Test
	public void testMapToJsonStr() throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("moible", "17717550328");
		String result = JsonUtil.map2JsonStr(param);
		System.out.println(result);
	}
}