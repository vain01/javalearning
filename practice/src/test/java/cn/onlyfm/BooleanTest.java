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

	@Test
	public void testChangeable() {
		Boolean setUserPrizeResult = Boolean.FALSE;
		setBooleanValue(setUserPrizeResult);
		System.out.println(setUserPrizeResult); //返回 false, Boolean是不可变对象
	}

	private void setBooleanValue(Boolean setUserPrizeResult) {
		setUserPrizeResult = Boolean.TRUE;
	}
}
