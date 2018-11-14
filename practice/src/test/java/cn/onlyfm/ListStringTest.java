package cn.onlyfm;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2018/10/30.
 */
public class ListStringTest {
	@Test
	public void testName() {
		String cat = "acbc";
		List<String> expectedCats = new ArrayList<>();
		String DELIMITER = ",";
		if (StringUtils.isNotBlank(cat)) {
			String[] cats = cat.split(DELIMITER);
			for (int i = 0; i < cats.length; i++) {
				expectedCats.add(cats[i]);
			}
			System.out.println(String.join(DELIMITER, expectedCats));
		}
	}
}
