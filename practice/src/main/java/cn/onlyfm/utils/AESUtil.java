package cn.onlyfm.utils;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * Created by zhangxiqiang on 2018/12/4.
 */
@Slf4j
public class AESUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static boolean initialized = false;

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) throws Exception {
        log.debug("content:{},password:{}", content, password);
        return encrypt(content, password.getBytes(DEFAULT_CHARSET));
    }


    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static String decrypt(byte[] content, String password) throws Exception {
        return new String(decrypt(content, password.getBytes(DEFAULT_CHARSET)), DEFAULT_CHARSET);
    }


    public static String encryptByHexString(String content, String password) throws Exception {
        return StringUtil.byte2hex(encrypt(content, password));
    }

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     */
    public static byte[] encrypt(String content, byte[] password) throws Exception {
        Key secretKey = getKey(password);
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        byte[] byteContent = content.getBytes(DEFAULT_CHARSET);
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(byteContent);
        return result; // 加密
    }


    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, byte[] password) throws Exception {
        Key secretKey = getKey(password);
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(content);
        return result; // 加密
    }

    /**
     *@Desc: 加密
     *@Auth: jifei
     *@Date: 2019/2/14 15:34
     **/
    public static String encrypt(byte[]content,String aesKey,String iv) {
        byte [] result = encrypt(content,aesKey.getBytes(),iv.getBytes());
        return new String(Base64Utils.encode(result));
    }

    /**
     *@Desc: 加密
     *@Auth: jifei
     *@Date: 2019/2/14 15:31
     **/
    public static byte[] encrypt(byte[] content, byte[] aesKey,byte [] ivByte){
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/ZeroBytePadding");
            Key sKeySpec = new SecretKeySpec(aesKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *@Desc: 解密
     *@Auth: jifei
     *@Date: 2019/2/14 15:34
     **/
    public static String decrypt(byte[]content,String aesKey,String iv) {
        byte [] result = decrypt(content,aesKey.getBytes(),iv.getBytes());
        return new String(result);
    }
    /**
     *@Desc: 解密
     *@Auth: jifei
     *@Date: 2019/2/14 15:31
     **/
    public static byte[] decrypt(byte[] content, byte[] aesKey,byte [] ivByte){
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/ZeroBytePadding");
            Key sKeySpec = new SecretKeySpec(aesKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void initialize() {
        if (initialized)
            return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }
    // 生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
    /**
     * 解决linux下每次产生的加密结果不一致
     *
     * @param strKey
     * @return
     */
    public static Key getKey(byte[] strKey) throws NoSuchAlgorithmException {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey);
            generator.init(128, secureRandom);
            return generator.generateKey();
        } catch (Exception e) {
            throw e;
        }
    }

}
