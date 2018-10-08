package cn.onlyfm;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/13.
 */
public class JodaTimeTest {
	@Test
	public void testJodaTime() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime);
		System.out.println("" + dateTime.getYear() + dateTime.getMonthOfYear() + dateTime.getDayOfMonth());
		Long now = 1534162287000L;
		dateTime = new DateTime(now);
		System.out.println(dateTime); // 2018-08-13T20:11:27.000+08:00
		System.out.println(dateTime.getMillis()); // 1534162287000
		System.out.println(dateTime.getMillisOfDay()); // 72687000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay()); // 1534089600000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay()); // 1534089600000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay() + ""); // 1534089600000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay() + ""); // 1534089600000
		System.out.println(new DateTime(dateTime.getMillis() - dateTime.getMillisOfDay())); // 2018-08-13T00:00:00.000+08:00
		dateTime = new DateTime(now).plusDays(1);
		System.out.println(new DateTime(dateTime.getMillis() - dateTime.getMillisOfDay())); // 2018-08-14T00:00:00.000+08:00
		DateTime beginTime = new DateTime(1534316966000L);
		System.out.println(beginTime);
		DateTime endTime = new DateTime(1534316966000L);
		System.out.println(endTime);
		Days intervalDays = Days.daysBetween(beginTime, endTime);
		System.out.println(intervalDays.getDays());
		for (int i = 0; i < intervalDays.getDays() + 1; i++) {
			System.out.println(i);
		}

	}

	@Test
	public void testPlusDays() {
		DateTime currentDateTime = new DateTime();
		System.out.println(currentDateTime.getMillis());
		System.out.println(currentDateTime.plusDays(30).getMillis());

	}

	@Test
	public void testStringDate() {
		DateTime dateTime = new DateTime("2018-8-7");
		System.out.println(dateTime.toDate());
		System.out.println(dateTime);
		dateTime.plusDays(1);
		System.out.println(dateTime);
	}

	@Test
	public void testDayMillis() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.getMillis());
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay());
		System.out.println(dateTime.getMillisOfDay());

		System.out.println(dateTime.plusDays(1).getMillis() - dateTime.plusDays(1).getMillisOfDay());
		System.out.println(dateTime.getMillis());
	}

	@Test
	public void testChangeable() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.getMillis());
		setDateTime(dateTime);
		System.out.println(dateTime.getMillis());//是不可变对象
	}

	private void setDateTime(DateTime dateTime) {
		dateTime.plusDays(1);
	}
}
