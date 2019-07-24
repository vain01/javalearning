package cn.onlyfm;

import cn.onlyfm.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/3/21.
 */
public class UserTest {
	@Test
	public void testName() {
		User user = new User();
		user.setName("abc");
		Assert.assertEquals(user.getName(), "abc");
	}
}
