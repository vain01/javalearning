package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.UUID;
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

	@Test
	public void testRandomString() {
		String uuid = UUID.randomUUID().toString().substring(0, 7);
		int rnd = ThreadLocalRandom.current().nextInt(uuid.length());
		System.out.println(rnd);
		System.out.println(uuid.substring(0, rnd));
		uuid = uuid.replace(uuid.substring(0, rnd), uuid.substring(0, rnd).toUpperCase());
		System.out.println(uuid);
	}
}
