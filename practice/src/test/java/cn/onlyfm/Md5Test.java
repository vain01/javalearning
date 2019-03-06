package cn.onlyfm;

import cn.onlyfm.utils.MD5Utils;
import org.testng.annotations.Test;

import java.security.NoSuchAlgorithmException;

/**
 * @author haoliang on 2019/3/6.
 */
public class Md5Test {
	@Test
	public void testName() throws NoSuchAlgorithmException {
		String testing = "abc";
		String ret = MD5Utils.encodeByMD5(testing);
		System.out.println(ret);
		System.out.println(ret.length());
	}
}
