package cn;

import cn.onlyfm.utils.Base64Utils;
import cn.onlyfm.utils.StringUtil;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/3/11.
 */
public class Base64Test {
	@Test
	public void testName() {
		String ori = "123qwe";
		String ret = StringUtil.byte2hex(Base64Utils.encode(ori.getBytes()));
		System.out.println(ret);
	}
}
