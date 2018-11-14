package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @author haoliang on 2018/10/22.
 */
public class OptionnalTest {
	@Test	public void testEntityNull() {
		User user = null;
		user = Optional.ofNullable(user).orElse(new User());
		System.out.println(user);
	}
}
