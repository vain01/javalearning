package cn.onlyfm;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author haoliang on 2019/3/6.
 */
public class LocalDateTimeTest {
	@Test
	public void testName() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
	}

	@Test
	public void testFormatter() {
		//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		System.out.println(localDateTime.format(dateTimeFormatter));
	}
}
