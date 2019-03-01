package cn.onlyfm;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/8/13.
 */
public class JodaTimeTest {
	@Test
	public void testYearMonthDay() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime); //2018-10-23T17:40:27.118+08:00
		System.out.println("" + dateTime.getYear() + dateTime.getMonthOfYear() + dateTime.getDayOfMonth()); //20181023
	}

	@Test
	public void testCurrentDayStart() {
		Long now = 1534162287000L;
		DateTime dateTime = new DateTime(now);

		System.out.println(dateTime); // 2018-08-13T20:11:27.000+08:00
		System.out.println(dateTime.getMillis()); // 1534162287000
		System.out.println(dateTime.getMillisOfDay()); // 72687000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay()); // 1534089600000
		System.out.println(dateTime.getMillis() - dateTime.getMillisOfDay() + ""); // 1534089600000
	}

	@Test
	public void testTomorrowStart() {
		Long now = 1534162287000L;
		DateTime dateTime = new DateTime(now);

		System.out.println(new DateTime(dateTime.getMillis() - dateTime.getMillisOfDay())); // 2018-08-13T00:00:00.000+08:00
		dateTime = new DateTime(now).plusDays(1);
		System.out.println(new DateTime(dateTime.getMillis() - dateTime.getMillisOfDay())); // 2018-08-14T00:00:00.000+08:00
	}

	@Test
	public void testThisMonthStart() {
		Long now = 1534162287000L;
		DateTime dateTime = new DateTime(now);
		System.out.println(dateTime);

		dateTime = dateTime.plusDays(0 - dateTime.getDayOfMonth() + 1);
		System.out.println(dateTime);

		Long todayStart = dateTime.getMillis() - dateTime.getMillisOfDay();
		System.out.println(todayStart);
		System.out.println(new DateTime(todayStart));
	}

	@Test
	public void testDaysBetween() {
		DateTime beginTime = new DateTime(1534316966000L);
		System.out.println(beginTime);  //2018-08-15T15:09:26.000+08:00
		DateTime endTime = new DateTime(1534426966000L);
		System.out.println(endTime);    //2018-08-16T21:42:46.000+08:00
		Days intervalDays = Days.daysBetween(beginTime, endTime);

		for (int i = 0; i < intervalDays.getDays() + 1; i++) {
			System.out.println(i);
		}

	}

	@Test
	public void testPlusDays() {
		Long now = 1534162287000L;
		DateTime currentDateTime = new DateTime(now);
		System.out.println(currentDateTime.getMillis());    //1534162287000
		System.out.println(currentDateTime);    //2018-08-13T20:11:27.000+08:00
		System.out.println(currentDateTime.plusDays(30).getMillis());   //1536754287000
		System.out.println(currentDateTime.plusDays(30));   //2018-09-12T20:11:27.000+08:00
	}

	@Test
	public void testStringDate() {
		DateTime dateTime = new DateTime("2018-8-7");
		System.out.println(dateTime.getMillis());
		System.out.println(dateTime.toDate());  //Tue Aug 07 00:00:00 CST 2018
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

	@Test
	public void testAllInOne() {
		Long time = 1540291260744L;
		DateTime currentDateTime = new DateTime(time);
		System.out.println(currentDateTime);    //2018-10-23T18:41:00.744+08:00

		Long todayStart = currentDateTime.getMillis() - currentDateTime.getMillisOfDay();
		System.out.println(new DateTime(todayStart));   //2018-10-23T00:00:00.000+08:00

		Long yesterDayStart = new DateTime(todayStart).plusDays(-1).getMillis();
		System.out.println(new DateTime(yesterDayStart));   //2018-10-22T00:00:00.000+08:00

		Long thisMonthStart = currentDateTime.minusDays(currentDateTime.getDayOfMonth() - 1).getMillis() - currentDateTime.getMillisOfDay();
		System.out.println(new DateTime(thisMonthStart));   //2018-10-01T00:00:00.000+08:00

		Long lastMonthStart = new DateTime(thisMonthStart).minusMonths(1).getMillis();
		System.out.println(new DateTime(lastMonthStart));   //2018-09-01T00:00:00.000+08:00
	}

	private void setDateTime(DateTime dateTime) {
		dateTime.plusDays(1);
	}
}
