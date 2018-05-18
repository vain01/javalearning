package cn.onlyfm.utils.encryption;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/17.
 */
public class DesUtilTest {

	@Test(dataProvider = "testDesEncryptData")
	public void testDesEncrypt(String content, String desKey, String expectedResult) throws Exception {
		Assert.assertEquals(DesUtil.desEncrypt(content, desKey), expectedResult);
	}

	@DataProvider(name = "testDesEncryptData")
	public Object[][] testDesEncryptData() {
		return new Object[][]{
			{"123", "haoliang", "fe7b08599c6835ed"},
			{"abc", "haoliang", "1ee4fb2d5f12d949"},
			{"", "haoliang", "8ebaaed251fd8bab"}
		};
	}

	@Test(dataProvider = "testDesDecryptData")
	public void testDesDecrypt(String encryptedContent, String desKey, String expectedResult) throws Exception {
		Assert.assertEquals(DesUtil.desDecrypt(encryptedContent, desKey), expectedResult);
	}

	@DataProvider(name = "testDesDecryptData")
	public Object[][] testDesDecryptData() {
		return new Object[][]{
			{"fe7b08599c6835ed", "haoliang", "123"},
			{"1ee4fb2d5f12d949", "haoliang", "abc"},
			{"8ebaaed251fd8bab", "haoliang", ""}
		};
	}
}