package cn.onlyfm;

import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author haoliang on 2018/11/14.
 */
public class BigDecimalTest {
	@Test
	public void testNull() {
		String nullStr = null;
		BigDecimal testing = new BigDecimal(nullStr);
		System.out.println(testing);    // NPE
	}

	@Test
	public void testStringToBD() {
		String priceStr = "9.9";
		BigDecimal testing = new BigDecimal(priceStr);
		System.out.println(testing);    //9.9
	}

	@Test
	public void testFloatToBD() {
		BigDecimal testingFromFloat = new BigDecimal(9.9);
		System.out.println(testingFromFloat);       //9.9000000000000003552713678800500929355621337890625
	}

	@Test
	public void testAdd() {
		BigDecimal a = new BigDecimal(100);
		BigDecimal b = new BigDecimal(200);

		BigDecimal result = a.add(b);
		System.out.println(result);
	}

	@Test
	public void testEquals() {
		BigDecimal source = BigDecimal.ZERO;
		System.out.println(source);
		BigDecimal target = BigDecimal.valueOf(0.000);
		System.out.println(target);
		System.out.println(source.equals(target));
		System.out.println(source.compareTo(target) == 0);
		System.out.println(source.equals(BigDecimal.ZERO));
	}

	@Test
	public void testPlus() {
		BigDecimal a = new BigDecimal(-100);

		BigDecimal result = a.plus();     //-100
		System.out.println(result);
	}

	@Test
	public void testNegate() {
		BigDecimal a = new BigDecimal(100);

		BigDecimal result = a.negate();     //-100
		System.out.println(result);
	}
}
