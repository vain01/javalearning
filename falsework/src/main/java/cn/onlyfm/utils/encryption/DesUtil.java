package cn.onlyfm.utils.encryption;

import cn.onlyfm.utils.StringUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author haoliang on 2018/5/17.
 */
public class DesUtil {
	public static final String ALGORITHM = "DES";

	/**
	 * DES加密
	 *
	 * @param content 待加密内容
	 * @param desKey
	 * @return 16进制字符串
	 * @throws Exception
	 */
	public static String desEncrypt(String content, String desKey) throws Exception {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			// 从原始密匙数据创建DESKeySpec对象
			DESKeySpec desKeySpec = new DESKeySpec(desKey.getBytes());
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(ALGORITHM);

			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			// 获取数据并加密
			return StringUtil.bytes2HexString(cipher.doFinal(content.getBytes()));
		} catch (Exception e) {
			throw new Exception("DES加密发生错误", e);
		}
	}

	/**
	 * DES解密
	 *
	 * @param encryptedContent 待解密内容
	 * @param desKey
	 * @return 16进制字符串
	 * @throws Exception
	 */
	public static String desDecrypt(String encryptedContent, String desKey) throws Exception {
		// 解密数据
		byte[] sourceBytes = StringUtil.hexString2Bytes(encryptedContent);
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			DESKeySpec desKeySpec = new DESKeySpec(desKey.getBytes());
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			Cipher cipher = Cipher.getInstance(ALGORITHM);

			// 获取数据并解密
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(sourceBytes));
		} catch (Exception e) {
			throw new Exception("DES解密发生错误", e);
		}
	}
}
