package cn.onlyfm.utils.encoding;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/15.
 */
public class Base64UtilTest {

	@Test(enabled = false)
	public void testEncode2bytes() throws Exception {
	}

	@Test(dataProvider = "testEncode2StringData")
	public void testEncode2String(String input, String expectedString) throws Exception {
		Assert.assertEquals(Base64Util.encode2String(input), expectedString);
	}

	@Test(enabled = false)
	public void testDecode2bytes() throws Exception {
	}

	@DataProvider(name = "testEncode2StringData")
	public Object[][] testEncode2StringData() {
		return new Object[][]{
			{"abc", "YWJj"},
			{"123", "MTIz"},
			{"好", "5aW9"},
			{"", ""}
		};
	}

	@Test(dataProvider = "testDecode2StringData")
	public void testDecode2String(String encodedString, String expectedString) throws Exception {
		Assert.assertEquals(Base64Util.decode2String(encodedString), expectedString);
	}

	@DataProvider(name = "testDecode2StringData")
	public Object[][] testDecode2StringData() {
		return new Object[][]{
			{"YWJj", "abc"},
			{"MTIz", "123"},
			{"5aW9", "好"},
			{"", ""}
		};
	}
}