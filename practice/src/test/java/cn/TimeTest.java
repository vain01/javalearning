package cn;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.testng.annotations.Test;

/**
 * @author hexadecimal on 2019/5/5.
 */
public class TimeTest {
	@Test
	public void testName() {
		DateTime dt = new DateTime();
		System.out.println(dt);
		System.out.println(dt.getMillis());
		System.out.println(dt.getMillisOfDay());
		System.out.println(dt.getMillis() - dt.getMillisOfDay());
	}

	@Test
	public void testDateTimeConstants() {
		System.out.println(DateTimeConstants.HOURS_PER_DAY);
	}
}
