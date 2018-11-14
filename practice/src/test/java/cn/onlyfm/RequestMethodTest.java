package cn.onlyfm;

import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/10/27.
 */
public class RequestMethodTest {
	@Test
	public void testEquals() {
		System.out.println(RequestMethod.GET.equals(RequestMethod.GET));
		System.out.println(RequestMethod.GET.equals(RequestMethod.POST));
	}
}
