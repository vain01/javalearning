package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2019/4/10.
 */
public class ForEachTest {
	@Test
	public void testName() {
		List<Long> ids = new ArrayList<>();
		ids.add(33L);

		ids.forEach(id-> System.out.println(id));
	}
}
