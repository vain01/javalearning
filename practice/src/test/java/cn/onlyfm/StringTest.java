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
	public void testEqual() {
		int value = 1;
		Object vObj = value;
		String vStr = "1";
		Object vStrObj = vStr;
		System.out.println(vStr.equals(value));
		System.out.println(vStr.equals(vObj));
		System.out.println(vStr.equals(vStrObj));
	}

	@Test
	public void testSubString() {
		String couponInfo = "满29元减15元";
		System.out.println(couponInfo.length());
		System.out.println(couponInfo.lastIndexOf("减"));
		String couponValue = couponInfo.substring(couponInfo.lastIndexOf("减") + 1, couponInfo.length() - 1);
		System.out.println(couponValue);

		couponValue = couponInfo.substring(couponInfo.lastIndexOf("减") + 1);
		System.out.println(couponValue);

		couponValue = couponInfo.substring(couponInfo.lastIndexOf("减") + 1);
		System.out.println(couponValue);

	}
}
