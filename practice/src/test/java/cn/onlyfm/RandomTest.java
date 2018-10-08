package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author haoliang on 2018/9/21.
 */
public class RandomTest {
	@Test
	public void testName() {
		int origin = 0;
		int bound = 100;
		for (int i = 0; i < bound; i++) {
			int random = ThreadLocalRandom.current().nextInt(origin, bound);
			System.out.println(random);
		}
	}
}
