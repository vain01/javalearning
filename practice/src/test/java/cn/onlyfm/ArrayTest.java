package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
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

	@Test
	public void testContains() {
		String[] supportedDays = " 15,21".split(",");
		Integer goods = 15;
		System.out.println(ArrayUtils.contains(supportedDays, goods.toString()));
	}


}
