package cn.onlyfm;

import cn.onlyfm.annotation.Person;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/11/13.
 */
public class LombokTest {
	@Test
	public void testNoAgrsConstructor() {
		Person person = new Person();
		System.out.println(person);
	}

	@Test
	public void testAllArgsConstructor() {
		Person person = new Person("abc", 178, 92);
		System.out.println(person);
	}


}
