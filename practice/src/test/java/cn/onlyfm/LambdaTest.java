package cn.onlyfm;

import cn.onlyfm.model.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexadecimal on 2019/5/27.
 */
public class LambdaTest {
	@Test
	public void testName() {
		List<User> users = new ArrayList<>();
		users.add(new User("a"));
		users.add(new User("b"));
		users.add(new User("c"));
		users.add(new User("d"));
		System.out.println(users);

		users.forEach(i->{
			if (i.getName().equals("c")) {
				i.setName("ccc");
			}
		});

		System.out.println(users);
	}
}
