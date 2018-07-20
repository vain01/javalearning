package cn.onlyfm.utils;

import org.apache.commons.lang3.time.StopWatch;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.concurrent.TimeUnit;

/**
 * @author haoliang on 2018/5/21.
 */
public class DateTimeUtil {
	/**
	 * 获取当前时间的秒数的Long型值，10位
	 *
	 * @return
	 */
	public static long getCurrentTimeSeconds() {
		return getCurrentTimeMillis() / 1000;
	}

	/**
	 * * 获取当前时间的毫秒数的Long型值，13位
	 *
	 * @return
	 */
	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取两个日期间的天数
	 *
	 * @param startDate 开始日期
	 * @param endDate   结束日期
	 * @return
	 */
	public static int getDiffDays(DateTime startDate, DateTime endDate) {
		return Days.daysBetween(startDate, endDate).getDays();
	}

	public static long getDiffTimeMillis(int seconds) {
		StopWatch watch = new StopWatch();
		watch.start();
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		watch.split();
		watch.stop();
		return watch.getSplitTime();
	}
}
