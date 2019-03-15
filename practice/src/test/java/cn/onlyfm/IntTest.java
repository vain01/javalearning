package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/3/7.
 */
public class IntTest {
	@Test
	public void testName() {
		double num = 0.999;
		int finalNum = (int) (num * 100);
		System.out.println(finalNum);
	}
}
