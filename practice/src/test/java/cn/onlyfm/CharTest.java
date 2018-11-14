package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/10/29.
 */
public class CharTest {
	@Test
	public void testCharFromString() {
		String testing = "abc";
		char c = testing.charAt(1);
		System.out.println(c + "");
		System.out.println(c == 'b');
	}
}
