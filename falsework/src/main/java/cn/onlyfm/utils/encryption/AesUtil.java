package cn.onlyfm.utils.encryption;

import cn.onlyfm.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author haoliang on 2018/5/15.
 * AES是一种对称加解密方式
 */
public class AesUtil {
	private static final String ALGORITHM = "AES";
	private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
	private static final int KEY_LENGTH = 128;
	private static final String CHARSET_NAME = "UTF-8";
	private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";

	/**
	 * AES加密
	 *
	 * @param content 待加密内容
	 * @param keySeed 产生加密key的种子
	 * @return 字符串
	 */
	public static String Encrypt(String content, String keySeed) throws Exception {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
			secureRandom.setSeed(keySeed.getBytes());
			keyGen.init(KEY_LENGTH, secureRandom);
			SecretKey secretKey = keyGen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return StringUtil.bytes2HexString(cipher.doFinal(content.getBytes(CHARSET_NAME)));
		} catch (Exception e) {
			throw new Exception("AES加密发生错误", e);
		}
	}

		/**
	 * AES解密
	 *
	 * @param encryptedContent 加密内容
	 * @param keySeed          产生加密key的种子
	 * @return
	 */
	public static String Decrypt(String encryptedContent, String keySeed) throws Exception {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
			secureRandom.setSeed(keySeed.getBytes());
			keyGen.init(KEY_LENGTH, secureRandom);
			SecretKey secretKey = keyGen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(StringUtil.hexString2Bytes(encryptedContent)));
		} catch (Exception e) {
			throw new Exception("AES解密发生错误", e);
		}
	}

	public static String aesEncrypt(String content, String keyStr) throws Exception {
		SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), ALGORITHM);
		String result = StringUtils.EMPTY;
		if (StringUtils.isEmpty(content)) {
			return result;
		}
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			result = StringUtil.bytesToHexString(cipher.doFinal(content.getBytes(CHARSET_NAME)));
		} catch (Exception e) {
			throw new Exception("AES加密发生错误", e);
		}
		return result;
	}

	public static String aesDecrypt(String encryptedContent, String keyStr) throws Exception {
		SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), ALGORITHM);
		String result = StringUtils.EMPTY;
		if (StringUtils.isEmpty(encryptedContent)) {
			return result;
		}
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = new String(cipher.doFinal(StringUtil.hexString2Bytes(encryptedContent)));
		}catch (Exception e){
			throw new Exception("AES解密发生错误", e);
		}
		return result;
	}
}
