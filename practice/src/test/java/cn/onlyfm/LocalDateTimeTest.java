package cn.onlyfm;

import org.testng.annotations.Test;

import java.time.LocalDateTime;

/**
 * @author haoliang on 2019/3/6.
 */
public class LocalDateTimeTest {
	@Test
	public void testName() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
	}
}
