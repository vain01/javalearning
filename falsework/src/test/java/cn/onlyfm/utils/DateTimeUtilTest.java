package cn.onlyfm.utils;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/21.
 */
public class DateTimeUtilTest {

	@Test
	public void testGetCurrentTimeSeconds() throws Exception {
		System.out.println(DateTimeUtil.getCurrentTimeSeconds());
	}

	@Test
	public void testGetCurrentTimeMillis() throws Exception {
		System.out.println(DateTimeUtil.getCurrentTimeMillis());
	}

	@Test
	public void testGetDiffDays() throws Exception {
		DateTime startDateTime = new DateTime("2018-4-29");
		DateTime endDateTime = new DateTime(DateTime.now());
		System.out.println(DateTimeUtil.getDiffDays(startDateTime, endDateTime));
	}

	@Test
	public void testGetDiffTimeMillis() throws Exception {
		int seconds = 3;
		long splitTime = DateTimeUtil.getDiffTimeMillis(seconds);
		System.out.println(splitTime);
	}
}