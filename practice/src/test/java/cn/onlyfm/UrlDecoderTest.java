package cn.onlyfm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author haoliang on 2019/3/1.
 */
public class UrlDecoderTest {
	@Test
	public void testName() throws UnsupportedEncodingException {
		String testing = "兰蔻小黑瓶面部精华肌底液75ml 修护滋润囤货套装";
		String encodedStr = URLEncoder.encode(testing, "UTF-8");
		System.out.println(encodedStr);
		String decodedStr = URLDecoder.decode(encodedStr, "UTF-8");
		System.out.println(decodedStr);
		Assert.assertEquals(testing, decodedStr);
	}
}
