package cn.onlyfm;

import org.testng.annotations.Test;

import java.text.DecimalFormat;

/**
 * @author haoliang on 2018/10/30.
 */
public class DecimalFormatTest {
	@Test
	public void testName() {
		Double commissionEstimatedValue = 24.527999999999995;
		DecimalFormat df = new DecimalFormat("#.##");
		commissionEstimatedValue = Double.valueOf(df.format(commissionEstimatedValue));
		System.out.println(commissionEstimatedValue);
	}

	@Test
	public void testDf() {

	}
}
