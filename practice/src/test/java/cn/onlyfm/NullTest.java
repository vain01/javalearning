package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/11/8.
 */
public class NullTest {
	@Test
	public void testNullPoint() {
		String abcd = null;
		System.out.println(("adsf").equals(abcd));
		System.out.println(abcd.equals("adsf"));
	}

	@Test
	public void testToString() {
		// System.out.println(null.toString());
	}

	@Test
	public void testStringEquals() {
		System.out.println("abc".equals("abc"));
		System.out.println("abc".equals("Abc"));
		System.out.println("abc".equalsIgnoreCase("Abc"));
		System.out.println("abc".equals(null));
		System.out.println("abc".equalsIgnoreCase(null));
	}
}
