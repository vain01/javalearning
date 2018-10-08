package cn.onlyfm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/9/20.
 */
public class JsonTest {
	@Test
	public void testJSONtoString() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 44);
		map.put("b", 445);
		String str = JSON.toJSONString(map);
		System.out.println(str);
	}

	@Test
	public void testName() {
		String origin = "{\"dailyRedPackageMaxAmount\":500,\"bamboomatTotalQuantity\":5}";
		JSONObject originJsonObject = JSON.parseObject(origin);
		System.out.println(originJsonObject);

		Object originObj= origin;
		JSONObject jsonObject = JSON.parseObject(originObj.toString());
		System.out.println(jsonObject);

	}
}
