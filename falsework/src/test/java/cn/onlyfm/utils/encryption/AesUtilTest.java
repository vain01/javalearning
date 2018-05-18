package cn.onlyfm.utils.encryption;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/17.
 */
public class AesUtilTest {

	@Test(dataProvider = "testAesEncryptData")
	public void testAesEncrypt(String content, String keySeed, String expectedEncryptedContent) throws Exception {
		Assert.assertEquals(AesUtil.aesEncrypt(content, keySeed), expectedEncryptedContent);
	}

	@DataProvider(name = "testAesEncryptData")
	public Object[][] testAesEncryptData() {
		return new Object[][]{
			{"123", "haoliang", "de4d0e16beb429ee0ec6d512bca1047d"},
			{"abc", "haoliang", "df0bdd8179e85ae2591a25b804505473"},
			{"", "haolaing", "b96c404fa4ece5bda8e05b81679d6767"}
		};
	}

	@Test(dataProvider = "testAesDecryptData")
	public void testAesDecrypt(String encryptedContent, String keySeed, String expectedContent) throws Exception {
		Assert.assertEquals(AesUtil.aesDecrypt(encryptedContent, keySeed), expectedContent);
	}

	@DataProvider(name = "testAesDecryptData")
	public Object[][] testAesDecryptData() {
		return new Object[][]{
			{"de4d0e16beb429ee0ec6d512bca1047d", "haoliang", "123"},
			{"df0bdd8179e85ae2591a25b804505473", "haoliang", "abc"},
			{"b96c404fa4ece5bda8e05b81679d6767", "haolaing", ""}
		};
	}
}