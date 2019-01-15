package cn.onlyfm.rsa;

import cn.onlyfm.utils.RSAUtils;
import org.testng.annotations.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author haoliang on 2019/1/14.
 */
public class RSATest {
	final String USER_DIR = System.getProperty("user.dir");

	String priFile = USER_DIR + "/src/test/java/cn/onlyfm/rsa/dev-pri-key.pem";
	final PrivateKey privateKey = RSAUtils.loadPrivateKey(priFile);
	String pubFile = USER_DIR + "/src/test/java/cn/onlyfm/rsa/dev-pub-key.pem";
	final PublicKey publicKey = RSAUtils.loadPublicKey(pubFile);
	String data = "{\"name\": \"郝亮\", \"cardNo\": \"6227001217380029555\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}";

	@Test
	public void testLoad() {
		//region 从文件中加载私钥,公钥
		final String USER_DIR = System.getProperty("user.dir");
		System.out.println(USER_DIR);

		String priFile = USER_DIR + "/src/test/java/cn/onlyfm/rsa/dev-pri-key.pem";
		String pubFile = USER_DIR + "/src/test/java/cn/onlyfm/rsa/dev-pub-key.pem";

		final PrivateKey privateKey = RSAUtils.loadPrivateKey(priFile);
		System.out.println(privateKey);
		final PublicKey publicKey = RSAUtils.loadPublicKey(pubFile);
		System.out.println(publicKey);
	}

	@Test
	public void test公钥加密私钥解密() {
		System.out.println("源数据:" + data);

		// 公钥加密
		String enc = RSAUtils.encryptByPublicKey(data, publicKey, "utf-8");
		System.out.println("公钥加密:" + enc);

		// 私钥解密
		String back = RSAUtils.decryptByPrivateKey(enc, privateKey, "utf-8");
		System.out.println("私钥解密:" + back);

		System.out.println("解密数据与源数据相同?" + back.equals(data));
	}

	@Test
	public void test私钥加密公钥解密() {
		System.out.println("源数据:" + data);

		//私钥加密
		String enc = RSAUtils.encryptByPrivateKey(data, privateKey, "utf-8");
		System.out.println("私钥加密:" + enc);

		//公钥解密
		String back = RSAUtils.decryptByPublicKey(enc, publicKey, "utf-8");
		System.out.println("公钥解密:" + back);

		System.out.println("解密数据与源数据相同?" + back.equals(data));

	}
}
