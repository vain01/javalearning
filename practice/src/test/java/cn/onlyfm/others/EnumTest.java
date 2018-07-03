package cn.onlyfm.others;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/7/2.
 */
public class EnumTest {
	@Test
	public void testAcceptStatus() {
		System.out.println(AcceptStatus.SUCCESS);
		System.out.println(AcceptStatus.SUCCESS.name());
		for (AcceptStatus acceptStatus : AcceptStatus.values()) {
			System.out.println(acceptStatus);
		}

		System.out.println();
		System.out.println(TransStatus.SUCCESS);
		System.out.println(TransStatus.SUCCESS.toString());
		System.out.println(TransStatus.SUCCESS.name());
		System.out.println(TransStatus.SUCCESS.name().toString());
	}
}
