package cn.onlyfm.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author haoliang on 2018/5/22.
 */
public class RandomUtil {

	/**
	 * 随机数，安全型
	 *
	 * @return
	 */
	public static int nextInt() {
		return ThreadLocalRandom.current().nextInt();
	}

	public static int nextInt(int length) {
		return nextInt(0, length);
	}

	public static int nextInt(int origin, int bound) {
		return ThreadLocalRandom.current().nextInt(origin, bound);
	}
}
