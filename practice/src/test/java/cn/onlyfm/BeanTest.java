package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/10/17.
 */
public class BeanTest {
	@Test
	public void testToString() {
		User user = new User();
		user.setUserName("abc");
		System.out.println(user);
	}
}
