package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.apache.commons.collections4.CollectionUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2018/9/11.
 */
public class ArrayTest {
	@Test
	public void testName() {
		List<User> userList = new ArrayList<>();
		System.out.println(CollectionUtils.isEmpty(userList));
		userList = null;
		System.out.println(CollectionUtils.isEmpty(userList));
	}
}
