package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/9/17.
 */
public class RegularTest {
	@Test
	public void testName() {
		String pattern = "^[\u4E00-\u9FA5|·]+$";
		// String name = "郝亮·";
		String name = "zhao";
		System.out.println(!name.matches(pattern));
	}
}
