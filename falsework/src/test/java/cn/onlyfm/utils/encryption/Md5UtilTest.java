package cn.onlyfm.utils.encryption;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/18.
 */
public class Md5UtilTest {

	@Test(dataProvider = "testMD5Data")
	public void testMD5(String content, String expectedResult) throws Exception {
		Assert.assertEquals(Md5Util.MD5(content), expectedResult);
	}

	@DataProvider(name = "testMD5Data")
	public Object[][] testMD5Data() {
		return new Object[][]{
			{"123", "202cb962ac59075b964b07152d234b70"},
			{"", "d41d8cd98f00b204e9800998ecf8427e"}
		};
	}
}