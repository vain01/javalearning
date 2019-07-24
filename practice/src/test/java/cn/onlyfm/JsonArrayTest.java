package cn.onlyfm;

import cn.onlyfm.model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2019/3/28.
 */
public class JsonArrayTest {
	@Test
	public void testName() {
		User u1 = new User("u1");
		User u2 = new User("u2");
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		System.out.println(users);

		String usersStr = JSON.toJSONString(users);
		System.out.println(usersStr);

		JSONArray jsonArray = JSONArray.parseArray(usersStr);
		System.out.println(jsonArray);

		List<User> ret = jsonArray.toJavaList(User.class);
		System.out.println(ret);
	}
}
