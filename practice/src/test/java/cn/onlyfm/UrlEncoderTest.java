package cn.onlyfm;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author haoliang on 2019/1/9.
 */
public class UrlEncoderTest {
	@Test
	public void testEncode() throws UnsupportedEncodingException {
		String testing = "兰蔻小黑瓶面部精华肌底液75ml 修护滋润囤货套装";
		String encodedStr = URLEncoder.encode(testing, "UTF-8");
		String expectedSts = "%E5%85%B0%E8%94%BB%E5%B0%8F%E9%BB%91%E7%93%B6%E9%9D%A2%E9%83%A8%E7%B2%BE%E5%8D%8E%E8%82%8C%E5%BA%95%E6%B6%B275ml+%E4%BF%AE%E6%8A%A4%E6%BB%8B%E6%B6%A6%E5%9B%A4%E8%B4%A7%E5%A5%97%E8%A3%85";
		System.out.println(encodedStr);
		String expectedStr = "%E5%85%B0%E8%94%BB%E5%B0%8F%E9%BB%91%E7%93%B6%E9%9D%A2%E9%83%A8%E7%B2%BE%E5%8D%8E%E8%82%8C%E5%BA%95%E6%B6%B275ml%20%E4%BF%AE%E6%8A%A4%E6%BB%8B%E6%B6%A6%E5%9B%A4%E8%B4%A7%E5%A5%97%E8%A3%85";
		String ex2 = "%E5%85%B0%E8%94%BB%E5%B0%8F%E9%BB%91%E7%93%B6%E9%9D%A2%E9%83%A8%E7%B2%BE%E5%8D%8E%E8%82%8C%E5%BA%95%E6%B6%B275ml%2B%E4%BF%AE%E6%8A%A4%E6%BB%8B%E6%B6%A6%E5%9B%A4%E8%B4%A7%E5%A5%97%E8%A3%85";

		System.out.println(encodedStr.equalsIgnoreCase(expectedStr));
		System.out.println(encodedStr.equalsIgnoreCase(ex2));
	}
}
