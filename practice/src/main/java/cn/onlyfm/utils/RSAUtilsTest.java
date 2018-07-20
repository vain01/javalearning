package cn.onlyfm.utils;

import com.alibaba.fastjson.JSONObject;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 * <p>
 * plain:{"age":18, "name": "zhangsan"} encrypt by public
 * key:HKlpDW0lNQ0DQRUf0BuXxeT0x8VMnzRvUg5pQNEFyflkKXlGeN/
 * NcRjFs8mpaAtmZ9rO5wovl3aP9YmuPxLOQXaPMGMo2jkdF0EQIZRHtT2ihA0iyDHy7+
 * oC2rTaDvB7J2Kr+ZJ8BQVsDT+B4tppgylHs2L07Sfk5cT6n9fBqq8= encrypt by private
 * key:Snjvlc9pwAr/FeifmI5yts1wA8pvZciF3xkjVBn36VcyonSflMWtFpypLN6YN45fnL+
 * yOKn0ulOxJb9LQXhJdX1cukEgoOlMpXRZZw9a1CZPEdhDi1XsIfvezNyht2/nsNYPGa0fL55+
 * 9pYPBmwgT2XN59p2Jw3PdrUm/+Drjqg=
 * <p>
 * </p>
 */
public class RSAUtilsTest {
	public static void main(String... strings) throws Exception {
		final String SELF_PRI_KEY = "src/main/java/cn/onlyfm/utils/rsa_key_paire_pkcs8.pem";
		final String SELF_PUB_KEY = "src/main/java/cn/onlyfm/utils/rsa_public_key.pem";
		final String TEST_PUB_KEY = "src/main/java/cn/onlyfm/utils/rsa_public_key(1).pem";
		final String PRO_PUB_KEY = "src/main/java/cn/onlyfm/utils/server.rsa_public_key.pem";
		final String userDir = System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));

		String signType = "SHA1WithRSA";
		// System.out.println(new String(s));
		final PrivateKey selfPrivateKey = RSAUtils.loadPrivateKey(userDir + "/" + SELF_PRI_KEY);
		// System.out.println("selfPrivateKey:" + selfPrivateKey);
		final PublicKey selfPublicKey = RSAUtils.loadPublicKey(userDir + "/" + SELF_PUB_KEY);
		// System.out.println("selfPublicKey:" + selfPublicKey);
		final PublicKey testPublicKey = RSAUtils.loadPublicKey(userDir + "/" + TEST_PUB_KEY);

		// String data = "{\"age\":18, \"name\": \"zhangsan\"}";
		// {
		// 	"name":"成娓娓",
		// 	"idCard":"421302199202081224",
		// 	"orgCode":"haoliang",
		// 	"channelCode":"CH000011"
		// }
		String data = "{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18321788695\"}"; //3要素 happy path
		// String data = "{\"idCard\":\"421302199202081204\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\"}"; //2要素 happy path
		System.out.println("-------------source:" + data);

		// // region
		// // 签名
		// String sign = RSAUtils.sign(signType, data.getBytes("utf-8"), selfPrivateKey);
		// System.out.println("-------------sign:" + sign);
		//
		// // 验签
		// boolean signOK = RSAUtils.verifySign(signType, data.getBytes("utf-8"), selfPublicKey, sign);
		// System.out.println("-------------signOK:" + signOK);
		//
		// // long start = System.currentTimeMillis();
		// // 公钥加密
		// String enc = RSAUtils.encryptByPublicKey(data, selfPublicKey, "utf-8");
		// System.out.println("-------------enc:" + enc);
		//
		// // 私钥解密
		// String back = RSAUtils.decryptByPrivateKey(enc, selfPrivateKey, "utf-8");
		// System.out.println("-------------back:" + back);
		//
		// // 私钥加密
		// String enc2 = RSAUtils.encryptByPrivateKey(data, selfPrivateKey, "utf-8");
		// System.out.println("-------------enc2:" + enc2);
		//
		// // 公钥解密
		// String back2 = RSAUtils.decryptByPublicKey(enc2, selfPublicKey, "utf-8");
		// System.out.println("-------------back2:" + back2);
		//
		// // long stop = System.currentTimeMillis();
		// // System.out.println("-----------done:" + (stop - start) / 1000);
		// // endregion

		List<String> datas = new ArrayList<String>();
		datas.add("{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18321788695\"}");
		datas.add("{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18321788699\"}"); //错误手机号
		datas.add("{\"idCard\":\"421302199202081229\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18321788695\"}"); //错误身份证

		datas.add("{\"idCard\":\"420625199308\", \"name\": \"潘桂琴\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18817789962\"}");
		datas.add("{\"idCard\":\"420625199308\", \"name\": \"程伟伟\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18817789962\"}");
		datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"潘桂琴\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18817789963\"}");
		datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"陈伟伟\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18817789962\"}");
		datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"潘桂琴\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\",\"phone\":\"18817789962\"}");
		datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"潘桂琴\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH00\",\"phone\":\"18817789962\"}");
		datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"潘桂琴\",\"orgCode\":\"ppp\",\"channelCode\":\"CH000011\",\"phone\":\"18817789962\"}");

		// datas.add("{\"idCard\":\"42062519930822254X\", \"name\": \"潘桂琴\",\"orgCode\":\"coin01\",\"channelCode\":\"CH000022\",\"phone\":\"18817789962\"}");
		for (int i = 0; i < datas.size(); i++) {
			// for (int i = 0; i < 2; i++) {
			data = datas.get(i);
			System.out.println();
			JSONObject jsonObject = JSONObject.parseObject(data);
			System.out.println(jsonObject);
			// System.out.print("curl -k -X POST http://alpha-101:9130/prpcredit/api.do?forward=api/1.0.0/out/realname/verification -d'");
			System.out.print("curl -k -X POST https://openapi-demo.crephet.com/prpcredit/api/1.0.0/out/realname/verification -d'");
			// System.out.print("curl -k -X POST http://alpha-101:9130/prpcredit/api.do?forward=api/1.0.0/out/mobile/verify -d'");
			// System.out.print("curl -k -X POST https://openapi-demo.crephet.com/prpcredit/api/1.0.0/out/mobile/verify -d'");
			System.out.print("orgCode=" + jsonObject.get("orgCode"));
			System.out.print("&channelCode=" + jsonObject.get("channelCode"));
			String signStr = RSAUtils.sign(signType, data.getBytes("utf-8"), selfPrivateKey);
			System.out.print("&sign=" + signStr);
			String encryptedBase64 = RSAUtils.encryptByPublicKey(data, testPublicKey, "utf-8"); //公钥加密并base64编码
			System.out.println("&reqData=" + java.net.URLEncoder.encode(encryptedBase64, "UTF-8") + "'");
		}

		// String respSign = "qFNDz73T5TFAAn4mKpUkLx2JD8PRukYdDnKNPrWe9Ip3Wh8OTfapnDSaP5ep5lF2I7kC37bisJncbj2bRozUmi+Gr5iogy8q240yWZbZtwAISZ71kJaF+uxkIzJAku4a1MjZhhE8a80Cv2Qfq6nnkEgV8SQALvAcxwpP5H234Ms=";
		// String respData = "Amujde5GewY65fbkDQin4Pz2pDTYnbPmdMuc789CZl2ZkqNAia5qSI1VOGCbSlPY2zio8whL3aTSRCiJTeIKtlE4Ny2E9YLz/ep0D7R4/gYbFLuITTusPkSOZ+pdeQKsBSWdLwK6KCtBU3X4wVlzo2lBUWvVmjoTQl9YcCNw3bkiT+bp2yK8LTsRnQPJuRuvklPOyfLPAR2I23z96s0+rhx4hTMbnHW+IICvCxA0lVxyi1RZ30TsVDXJdDt2fxthLhSANshoW8EArouDU7vWkTD8DMM/QthrWFrzSOceAmUrT0aE91xnxgsae4NzqHMxpR6F2N0uf7Tz+StBWnRZMQ==";

		// String respSign = "CVi/zPe4oTIUtEvCBHTmpDGOG7UxxtgP6UR8Zy0QBQipm14GAx4qlDp/eN5k8UN13oJvmF/42JBAMrpfoHFB4Ny2banKn1LbE6Ik+nUtMNQY1X6GrQM61q71/2ylrk5Hw9bM9QrnYFRKS37+wOLAHbxlTYy4HpcI74nuB8F2vaU=";
		// String respData = "RCM135/lRzw9zISAOrhGDyFmL5CueKhBCLHPuFfPPCvVWJWEoRCo4wRJUG5XRDvuU1pANVhceT+JzfzCTkdPZKesp6FwiHp/N3AxxmuSzwrKJTJ33V8EdGLkIA4ud1NEZeDujTjtnDjd8H6pDW62j9njuF52MDlQB4vB/OUZOHAvPRXcHhCb2m9GlUGpD3Bqc34cDNOhzyV1j3oG2JAlXTMCkadrBeqyZTP6yCSa2X0L2HsiI6hXK4T0mR7YI0OZWFJv1sifSiGGJqo/BJUkW34ytEzA0YHhXZRy+pEVX0h2zvqu9Opco9tpSOdOb9ocRmrrJW4Qw30f2it8HUFMAw==";

		String respSign = "qFNDz73T5TFAAn4mKpUkLx2JD8PRukYdDnKNPrWe9Ip3Wh8OTfapnDSaP5ep5lF2I7kC37bisJncbj2bRozUmi+Gr5iogy8q240yWZbZtwAISZ71kJaF+uxkIzJAku4a1MjZhhE8a80Cv2Qfq6nnkEgV8SQALvAcxwpP5H234Ms=";
		String respData = "SqytuQ53BeOqRDsQ5iiJPsuwzCFERwCLK1UwVUi9JSDB7tPZaL6WDsZXjvBMePvu0AnTNUfHhxqBTjdUzc6JYfFEqQmAw/AtDjc43UZQKPP5Lk+qGxMgh3R5aVFpjEqTPhLP+1I47YjV/Sl8pJdNPZcdZbVOcG7f7IGWKdHFRYFQ1VGGHsi7d96iEq8/nhmQLqsRQ6oxxG4AkHxpmq/Kmu3susTMAdzkPWjTv+KEJojg98d/D45AVoEt9ErRB/ou6qq0iCDmYo8prRYovnC3KMNnlxy+9gs4yUaRCUkF65cisDmJdmP6H/lOquRuGE3VDgkT1VyoTWwC2uqP/k1OqA==";

		String decryptedJson = RSAUtils.decryptByPrivateKey(respData, selfPrivateKey, "utf-8");
		System.out.println(decryptedJson);
		boolean respSignStatus = RSAUtils.verifySign(signType, decryptedJson.getBytes("utf-8"), testPublicKey, respSign);
		System.out.println("验签:" + respSignStatus);
	}

}
