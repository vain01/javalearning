package cn.onlyfm;

import org.testng.annotations.Test;

import java.text.DecimalFormat;

/**
 * @author haoliang on 2018/9/13.
 */
public class DoubleTest {
	@Test
	public void testName() {
		DecimalFormat df = new DecimalFormat("#.##");

		String first = "455";
		System.out.println(Double.valueOf(first));
		String second = "10";
		System.out.println(Double.valueOf(second));
		System.out.println(Double.valueOf(second).toString());
		System.out.println(df.format(Double.valueOf(second)));
		System.out.println((Double.valueOf(first) - Double.valueOf(second)) + "");
		System.out.println(df.format(Double.valueOf(first) - Double.valueOf(second)));
	}

	@Test
	public void testDoubleString() {
		String input = "9.3";
		Double ret = Double.valueOf(input);
		System.out.println(ret);
	}

	@Test
	public void testCompare() {
		Double left = 2.3;
		Double right = 0.0;
		System.out.println(left.compareTo(right));
	}

	@Test
	public void testCompareToZero() {
		double a=0.0;
		if (a == 0) {
			System.out.println("zero");
		}
		String zeroStr = "0";
		System.out.println("0 Str:" + (Double.valueOf(zeroStr).compareTo(0.0) == 0));
		String zeroPointStr = "0.0";
		System.out.println("0.0 Str:" + (Double.valueOf(zeroPointStr).compareTo(0.0) == 0));
	}
}
