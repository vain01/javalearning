package cn.onlyfm;

import org.testng.annotations.Test;

import java.time.ZoneId;

/**
 * @author haoliang on 2019/3/19.
 */
public class ZoneIdTest {
	@Test
	public void testName() {
		ZoneId zoneId = ZoneId.of("Asia/Shanghai");
		System.out.println(zoneId);
		// System.out.println(ZoneId.SHORT_IDS);
	}
}
