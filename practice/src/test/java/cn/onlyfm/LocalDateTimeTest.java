package cn.onlyfm;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		System.out.println(localDateTime.format(dateTimeFormatter));
	}

	@Test
	public void testNano() {
		Long now = System.currentTimeMillis();
		System.out.println(now);
		Instant instant = Instant.ofEpochMilli(now);
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());
		System.out.println(localDateTime);
		System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	}

	@Test
	public void testMinus() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);//2019-03-20T17:02:18.815
		LocalDateTime ldt = localDateTime.minusYears(1L);
		System.out.println(ldt);//2019-03-19T17:02:18.815

		System.out.println(localDateTime.compareTo(ldt));
	}

	@Test
	public void testEquals() {
		long expectedMilliseconds = (7 * 24 * 60 * 60 + 3600) * 1000;
		System.out.println(expectedMilliseconds);
		Long redisExpireTime = LocalDateTime.now().plusDays(7).plusHours(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()
			-LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		System.out.println(redisExpireTime);
	}

	@Test
	public void testGetNano() {
		System.out.println(LocalDateTime.now().plusDays(7).plusHours(1).getNano());
		System.out.println(LocalDateTime.now().getNano());
		System.out.println(LocalDateTime.now().plusDays(7).plusHours(1).getNano()-LocalDateTime.now().getNano());
	}
}
