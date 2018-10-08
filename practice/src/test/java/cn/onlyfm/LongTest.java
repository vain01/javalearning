package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/28.
 */
public class LongTest {
	@Test
	public void testName() {
		Long a = 9L;
		System.out.println(a.toString());
		Long b = 10L;
		int ret = (int) (a - b);
		System.out.println(a - b);

		Long x = 500L;
		Long y = 500L;
		System.out.println(x == 500L);  //true
		System.out.println(x <= 500L);  //true
		System.out.println(x == 500L);  //true
		System.out.println(y == 500L);  //true
		System.out.println(x == y); //false
		System.out.println(Long.compare(x, y));    //0
		System.out.println(Long.compare(x, y) == 0);    //true

		System.out.println(Long.compare(x, y)); // 0
		x = 501L;
		y = 500L;
		System.out.println(Long.compare(x, y)); // 1
		x = 499L;
		y = 500L;
		System.out.println(Long.compare(x, y)); // -1
	}

	@Test
	public void testLong() {
		Long l = Long.valueOf(null);
		System.out.println(l);
	}

	@Test
	public void testMinMax() {
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
