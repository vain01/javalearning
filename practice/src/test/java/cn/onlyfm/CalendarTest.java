package cn.onlyfm;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author hexadecimal on 2019/5/13.
 */
public class CalendarTest {
	@Test
	public void testDayOfYear() {
		Calendar calendar= Calendar.getInstance();
		int catIndex = calendar.get(Calendar.DAY_OF_YEAR) % 10;
		System.out.println(catIndex);
	}

	@Test
	public void testName() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.getTimeInMillis());
		calendar.add(Calendar.MINUTE, 10);
		System.out.println(calendar);
		System.out.println(System.currentTimeMillis());
	}

	@Test
	public void testSetTime() {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MINUTE, 20);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, 15);
		System.out.println(calendar.getTime());
	}

	@Test
	public void testWorkdays() {
		String end = getFinalConfirmationDate();
		System.out.println(end);
	}

	private String getFinalConfirmationDate() {
		String datetime = "2019-04-02 20:52:49";
		datetime = datetime.substring(0, datetime.indexOf(" "));
		System.out.println(datetime);

		String[] date = datetime.split("-");
		Calendar start = Calendar.getInstance();
		start.set(Calendar.YEAR, Integer.valueOf(date[0]));
		start.set(Calendar.MONTH, Integer.valueOf(date[1]) - 1);//月份比正常小1,0代表一月
		start.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date[2]));
		String startDay = getDay(start);
		System.out.println(startDay);

		int workdays = 7;
		while (workdays > 0) {
			boolean workday = isWorkday(startDay);
			start.add(Calendar.DAY_OF_MONTH, 1);
			startDay = getDay(start);
			if (workday) {
				workdays--;
			}
		}

		return startDay;
	}

	@Test
	public void testFinalExcludedDayList() {
		// System.out.println(getFinalExcludedDays());
		String holidayList = StringUtils.EMPTY;
		for (String item : getFinalExcludedDays()) {
			holidayList += item + ",";
		}
		holidayList = holidayList.substring(0, holidayList.length() - 2);
		System.out.println(holidayList);
		System.out.println(holidayList.split(",").length);
		System.out.println(isWorkday("2019-10-7"));
	}

	public boolean isWorkday(String day) {
		return !getFinalExcludedDays().contains(day);
	}

	public Set<String> getFinalExcludedDays() {
		Set<String> finalExcludedDaySet = new HashSet<>();
		finalExcludedDaySet.addAll(getWeekendList());
		finalExcludedDaySet.addAll(getHolidayList());
		finalExcludedDaySet.removeAll(getAdjustedWorkingDayList());

		// System.out.println(finalExcludedDaySet.size());
		return finalExcludedDaySet;
	}

	public List<String> getWeekendList() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, 0);//月份比正常小1,0代表一月
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		List<String> weekendList = new ArrayList<>();
		while (calendar.get(Calendar.YEAR) < 2020) {
			boolean isWeekend = calendar.get(Calendar.DAY_OF_WEEK) == calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == calendar.SATURDAY;
			if (isWeekend) {
				String weekend = getDay(calendar);
				weekendList.add(weekend);
			}
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		// System.out.println(weekendList.size());
		return weekendList;
	}

	private String getDay(Calendar calendar) {
		return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
	}

	public List<String> getHolidayList() {
		List<String> holidayList = new ArrayList<>();
		holidayList.add("2019-1-1");

		holidayList.add("2019-2-4");
		holidayList.add("2019-2-5");
		holidayList.add("2019-2-6");
		holidayList.add("2019-2-7");
		holidayList.add("2019-2-8");
		holidayList.add("2019-2-9");
		holidayList.add("2019-2-10");

		holidayList.add("2019-4-5");
		holidayList.add("2019-4-6");
		holidayList.add("2019-4-7");

		holidayList.add("2019-6-7");
		holidayList.add("2019-6-8");
		holidayList.add("2019-6-9");

		holidayList.add("2019-9-13");
		holidayList.add("2019-9-14");
		holidayList.add("2019-9-15");

		holidayList.add("2019-10-1");
		holidayList.add("2019-10-2");
		holidayList.add("2019-10-3");
		holidayList.add("2019-10-4");
		holidayList.add("2019-10-5");
		holidayList.add("2019-10-6");
		holidayList.add("2019-10-7");

		// System.out.println(holidayList.size());
		return holidayList;
	}

	public List<String> getAdjustedWorkingDayList() {
		List<String> adjustedWorkingDayList = new ArrayList<>();
		adjustedWorkingDayList.add("2019-2-2");
		adjustedWorkingDayList.add("2019-2-3");
		adjustedWorkingDayList.add("2019-4-28");
		adjustedWorkingDayList.add("2019-5-5");
		adjustedWorkingDayList.add("2019-9-29");
		adjustedWorkingDayList.add("2019-10-12");

		// System.out.println(adjustedWorkingDayList.size());
		return adjustedWorkingDayList;
	}


}
