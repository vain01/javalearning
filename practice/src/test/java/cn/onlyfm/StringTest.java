package cn.onlyfm;

import cn.onlyfm.utils.StringUtil;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2018/8/22.
 */
public class StringTest {
	@Test
	public void testArray() {
		// String catStr = "19,10";
		String catStr = "19";
		String[] cats = catStr.split(",");
		for (int i = 0; i < cats.length; i++) {
			System.out.println(cats[i]);
		}
	}

	@Test
	public void testJoin() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");

		System.out.println(String.join(",", list));
	}

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

	@Test
	public void testSubStringSimple() {
		String testing = "0123456";
		System.out.println(testing.substring(2, testing.length()));
	}

	@Test
	public void testasf() {
		String origin = "null";
		int expectedMaxLength = 3;
		String ret = StringUtil.getProperLengthString(origin, expectedMaxLength);
		System.out.println(ret);
	}

	@Test
	public void testContains() {
		String origin = "lgb,mbt";
		boolean ret = origin.contains("lgb".toLowerCase());
		System.out.println(ret);
		// boolean res = origin.contains(null);
		// System.out.println(res);
	}

	@Test
	public void testStringNull() {
		String testing = "abc";
		System.out.println(testing + null);
		System.out.println(testing.equals(null));
	}

	@Test
	public void testTrim() {
		String testing = " abc ";
		System.out.println("--" + testing.trim() + "--");
	}

	@Test
	public void testEmoj() {
		String testing = "\\xF0\\x9F\\x98\\x84";
		System.out.println(StringUtil.doesContainEmoj(testing));
	}

	@Test
	public void testStringContains() {
		String companyChannel = "blackcard";
		String marketChannel = "lgb";
		System.out.println(!companyChannel.contains(marketChannel));
	}

	@Test
	public void testToString() {
		Object o = "abc";
		System.out.println(o.toString().substring(0, 2));
		Object s = "xyz";
		System.out.println(s.toString().substring(0, 2));
	}

	@Test
	public void testEmojFilter() {
		String testing = "\\xF0\\x9F\\x98\\x84";
		System.out.println(StringUtil.containsEmoji(testing));
	}

	@Test
	public void testConcat() {
		String aHex = Integer.toHexString(1);
		System.out.println(aHex);
		System.out.println(aHex.concat("0"));
	}
}
