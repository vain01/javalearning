package cn.onlyfm;

import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author haoliang on 2018/11/14.
 */
public class BigDecimalTest
{
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
}
