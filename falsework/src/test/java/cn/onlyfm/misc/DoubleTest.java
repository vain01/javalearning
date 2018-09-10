package cn.onlyfm.misc;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/17.
 */
public class DoubleTest {
	@Test
	public void testDouble() {
		Double ret= 1/100d;
		System.out.println(ret);
		System.out.println(ret.getClass());
		System.out.println(ret.toString());
		System.out.println((ret.toString()).getClass());
	}
}
