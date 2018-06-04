package cn.onlyfm.utils.encryption;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/18.
 */
public class Md5UtilTest {

	@Test(dataProvider = "testMD5Data")
	public void testMD5(String content, String expectedResult) throws Exception {
		Assert.assertEquals(Md5Util.md5(content), expectedResult);
	}

	@DataProvider(name = "testMD5Data")
	public Object[][] testMD5Data() {
		return new Object[][]{
			{"123", "202cb962ac59075b964b07152d234b70"},
			{"", "d41d8cd98f00b204e9800998ecf8427e"},
			{"Ch12332100", "271a73c29be4e9a790b627ed188ae4c1"},
			{"Ch123321009c295211cefc44ac8c5c7bcf1a1e219a", "2c706e6c7af2da22db8df012537b2392"},
			{"271a73c29be4e9a790b627ed188ae4c19c295211cefc44ac8c5c7bcf1a1e219a", "46e86bc05468c06eb3b1d95151bc1c99"},
			{"abc", DigestUtils.md5Hex("abc")}
		};
	}

}