package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/9/7.
 */
public class BooleanTest {
	@Test
	public void testName() {
		boolean ret = new Boolean("1");
		System.out.println(ret);
	}
}
