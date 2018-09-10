package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/22.
 */
public class StringTest {
	@Test
	public void testStr() {
		String a = null;
		String b = "e";
		// System.out.println(a.equals(b)); //NPE
		System.out.println(b.equals(a)); // false
	}

	@Test
	public void testSubString() {
		String couponInfo = "满29元15元减";
		System.out.println(couponInfo.length());
		System.out.println(couponInfo.lastIndexOf("减"));
		String couponValue = couponInfo.substring(couponInfo.lastIndexOf("减") + 1);
		System.out.println(couponValue);
		couponValue = couponInfo.substring(8);
		System.out.println(couponValue);
		System.out.println(8888888);
		
		// couponValue = couponInfo.substring(couponInfo.lastIndexOf("减") + 2);    //StringIndexOutOfBoundsException
		// System.out.println(couponValue);
	}
}
