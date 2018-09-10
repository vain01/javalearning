package cn.onlyfm.misc;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/20.
 */
public class LongTest {
	@Test
	public void testLong() {
		Long x = 500L;
		Long y = 500L;
		System.out.println(x == 500L);  //true
		System.out.println(x <= 500L);  //true
		System.out.println(x == 500L);  //true
		System.out.println(y == 500L);  //true
		System.out.println(x == y); //false
		System.out.println(Long.compare(x, y) == 0);    //true
		x = 1534313411000L;
		y = 1534313411000L;
		System.out.println(x == y); //false
	}
}
