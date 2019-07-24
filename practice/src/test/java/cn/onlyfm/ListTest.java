package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author haoliang on 2018/9/5.
 */
public class ListTest {
	@Test
	public void testSize() {
		List<User> users = new ArrayList<>();
		System.out.println(users.size());
	}

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

	@Test
	public void testAddAll() {
		List<String> list = new ArrayList<>();
		System.out.println(list);
		List<String> sf = new ArrayList<>();
		list.addAll(sf);
		System.out.println(list);
		list.add(null);
		System.out.println(list);
	}

	@Test
	public void testPage() {

		List<String> retData = new ArrayList<>();
		retData.add("a");
		retData.add("b");
		retData.add("c");
		retData.add("d");
		retData.add("e");
		retData.add("f");
		retData.add("g");
		retData.add("h");
		retData.add("i");
		retData.add("j");

		int pageSize = 3;
		int pageNo = 13;
		try {
			int lowIndex = pageSize * (pageNo - 1);
			int hightIndex = pageSize * pageNo;
			hightIndex = retData.size() >= lowIndex && retData.size() <= hightIndex
					? retData.size() % pageSize + pageSize * (pageNo - 1)
					: hightIndex;
			retData = retData.subList(lowIndex, hightIndex);
			System.out.println(retData);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAdd() {
		List<String> testing = Arrays.asList("a,b,c".split(","));
		System.out.println(testing);
		System.out.println(testing.size());
		testing.add("a");
		System.out.println(testing);
		System.out.println(testing.size());
	}
}
