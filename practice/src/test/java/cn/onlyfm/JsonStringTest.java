package cn.onlyfm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/9/25.
 */
public class JsonStringTest {
	@Test
	public void testName() {
		String ret = "{\"status\":\"1\",\"data\":{\"id\":51,\"addTime\":1537520733507,\"expressStatus\":0}}";
		System.out.println(ret);
		System.out.println(JSON.toJSONString(ret));
		JSONObject retOjb = JSONObject.parseObject(ret);
		System.out.println(retOjb);
		System.out.println(retOjb.get("status"));

		String retJsonStr = JSON.toJSONString(ret);
		System.out.println(retJsonStr);
		String xx = JSON.parse(retJsonStr).toString();
		System.out.println(xx);
		JSONObject retJsonStrOjb = JSONObject.parseObject(xx);
		System.out.println(retJsonStrOjb.get("status"));
	}

	@Test
	public void testString() {
		String test = "\"[{\\\"result\\\":0,\\\"reason\\\":\\\"17\\\",\\\"fundId\\\":\\\"9439A3C3-2FFD-4C43-BEFE-1AEE3FFCC5CB\\\"},{\\\"result\\\":0,\\\"reason\\\":\\\"17\\\",\\\"fundId\\\":\\\"D89176AA-11D5-4818-A294-305E9DC513E1\\\"},{\\\"result\\\":1,\\\"reason\\\":\\\"3\\\",\\\"fundId\\\":\\\"025E9C39-BD40-4DC4-97A8-89519E6B2AF6\\\"}]\"";
		test = JSON.parse(test).toString();
		System.out.println("test is " + test);
		JSONArray testA = (JSONArray) JSONArray.parse(test);
		System.out.println("testA is " + testA);
		JSONObject testO = testA.getJSONObject(0);
		System.out.println("testO is " + testO);

	}
}
