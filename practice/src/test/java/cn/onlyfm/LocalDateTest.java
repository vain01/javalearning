package cn.onlyfm;

import org.testng.annotations.Test;

import java.time.*;

/**
 * @author haoliang on 2018/9/5.
 */
public class LocalDateTest {
	@Test
	public void testName() {
		LocalDate startTime = LocalDate.parse("2018-08-19");
		System.out.println(startTime);
		System.out.println(LocalDate.now());
		LocalDate registDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(1537372517000L), ZoneId.systemDefault()).toLocalDate();
		System.out.println(registDate);
		System.out.println(registDate.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli());
		System.out.println(registDate.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli() - 1000);
	}
}
