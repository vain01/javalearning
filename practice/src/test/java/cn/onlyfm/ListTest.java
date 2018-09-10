package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author haoliang on 2018/9/5.
 */
public class ListTest {
	@Test
	public void testName() {
		User one = new User();
		one.setMoblie(889L);
		one.setUserName("abc");
		User two = new User();
		two.setMoblie(887L);
		two.setUserName("edf");
		List<User> users = new ArrayList<>();
		users.add(one);
		users.add(two);
		List<Long> abc = new ArrayList<>();
		abc.add(889L);
		abc.add(777L);
		abc.add(999L);
		System.out.println(abc);
		Collections.sort(abc);
		System.out.println(abc);
		Collections.sort(abc, Collections.reverseOrder());
		System.out.println(abc);

	}
}
