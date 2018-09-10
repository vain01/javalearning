package cn.onlyfm.others;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/7/2.
 */
public class EnumTest {
	@Test
	public void testAcceptStatus() {
		System.out.println(AcceptStatus.SUCCESS);   //1:成功
		System.out.println(AcceptStatus.SUCCESS.name()); //SUCCESS
		for (AcceptStatus acceptStatus : AcceptStatus.values()) {
			System.out.println(acceptStatus);
		}

		System.out.println();
		System.out.println(TransStatus.SUCCESS);    //成功
		System.out.println(TransStatus.SUCCESS.toString()); //成功
		System.out.println(TransStatus.SUCCESS.name()); //SUCCESS
		System.out.println(TransStatus.SUCCESS.name().toString());  //SUCCESS
	}
}
