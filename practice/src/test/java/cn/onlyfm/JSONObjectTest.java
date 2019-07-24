package cn.onlyfm;

import cn.onlyfm.annotation.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

/**
 * @author hexadecimal on 2019/6/13.
 */
public class JSONObjectTest {
	@Test
	public void testName() {
		User user = new User();
		// user.setUserName("abc");
		// user.setMobile(44L);
		String str = JSON.toJSONString(user);
		System.out.println(str);
		JSONObject jsonObject = JSON.parseObject(str);
		System.out.println(jsonObject);
		// System.out.println(user.getMobile());
		// System.out.println(jsonObject.get("mobile"));
		// System.out.println(jsonObject.getBigDecimal("mobile"));
		System.out.println(jsonObject.get("userName"));
		System.out.println(jsonObject.getString("userName"));
		System.out.println(jsonObject.getBigDecimal("userName"));
		System.out.println(null == jsonObject.get("userName"));
	}
}
