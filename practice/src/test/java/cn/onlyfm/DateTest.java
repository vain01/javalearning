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
		Date date = new Date(1552975921695L);
		System.out.println(date);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String result = df.format(date);
		System.out.println(result); //2018-09-03

		System.out.println(date.toString());
	}
}
