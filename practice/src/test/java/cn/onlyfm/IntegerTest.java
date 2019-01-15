package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/11/19.
 */
public class IntegerTest {
	@Test
	public void testIntEqualsInteger() {
		int a = 9;
		Integer b = 9;
		System.out.println(a == b);
	}

	@Test
	public void testIntegerAndInt() {
		String pageSize = "33";
		int a = Integer.valueOf(pageSize);
		System.out.println(a);
	}
}
