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
}
