package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author haoliang on 2018/9/17.
 */
public class RegularTest {
	@Test
	public void testName() {
		String pattern = "^[\u4E00-\u9FA5|·]+$";
		// String name = "郝亮·";
		String name = "zhao";
		System.out.println(!name.matches(pattern));
	}

	/**
	 * 出现在任意位置的表情符匹配
	 */
	@Test
	public void testEmoji() {
		String str = "uy\\xF0\\x9F\\x91\\x86lkjl";
		String pattern = ".*(\\\\x[A-Za-z0-9]{2}){4}.*";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
		System.out.println(m);

		System.out.println(str.matches(pattern));
	}
}
