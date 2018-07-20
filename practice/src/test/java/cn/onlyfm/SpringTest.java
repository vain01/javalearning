package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/7/16.
 */
public class SpringTest {

	@Test
	public void testShowPath() throws Exception {
		Spring spring = new Spring();
		spring.showPath();
	}
}