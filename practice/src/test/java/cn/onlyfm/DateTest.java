package cn.onlyfm;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haoliang on 2018/9/3.
 */
public class DateTest {
	@Test
	public void testName() throws ParseException {
		Date date = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);

		// String result = df.format(date);
		String result = df.format(df.parse("2048-8-9"));
		System.out.println(result); //2018-09-03
		System.out.println(date);
		System.out.println(date.toString());
	}
}
