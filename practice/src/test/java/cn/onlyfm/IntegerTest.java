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
		System.out.println(b.equals(9));
	}

	@Test
	public void testIntegerAndInt() {
		String pageSize = "33";
		int a = Integer.valueOf(pageSize);
		System.out.println(a);
	}

	@Test
	public void testIntergerInt() {
		int a = 3;
		Integer b = a;
		System.out.println(b);
	}

	@Test
	public void testIntegerEmptyString() {
		String a = "";
		int b = Integer.valueOf(a);
		System.out.println(b);
	}

	@Test
	public void testIntegerString() {
		Integer enabled = 1;
		System.out.println(enabled.toString());
		System.out.println(enabled + "");
	}
}
