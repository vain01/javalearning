package cn.onlyfm.utils;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

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

		String respSign = "qFNDz73T5TFAAn4mKpUkLx2JD8PRukYdDnKNPrWe9Ip3Wh8OTfapnDSaP5ep5lF2I7kC37bisJncbj2bRozUmi+Gr5iogy8q240yWZbZtwAISZ71kJaF+uxkIzJAku4a1MjZhhE8a80Cv2Qfq6nnkEgV8SQALvAcxwpP5H234Ms=";
		String respData = "SqytuQ53BeOqRDsQ5iiJPsuwzCFERwCLK1UwVUi9JSDB7tPZaL6WDsZXjvBMePvu0AnTNUfHhxqBTjdUzc6JYfFEqQmAw/AtDjc43UZQKPP5Lk+qGxMgh3R5aVFpjEqTPhLP+1I47YjV/Sl8pJdNPZcdZbVOcG7f7IGWKdHFRYFQ1VGGHsi7d96iEq8/nhmQLqsRQ6oxxG4AkHxpmq/Kmu3susTMAdzkPWjTv+KEJojg98d/D45AVoEt9ErRB/ou6qq0iCDmYo8prRYovnC3KMNnlxy+9gs4yUaRCUkF65cisDmJdmP6H/lOquRuGE3VDgkT1VyoTWwC2uqP/k1OqA==";

		String decryptedJson = RSAUtils.decryptByPrivateKey(respData, selfPrivateKey, "utf-8");
		System.out.println(decryptedJson);
		boolean respSignStatus = RSAUtils.verifySign(signType, decryptedJson.getBytes("utf-8"), testPublicKey, respSign);
		System.out.println("验签:" + respSignStatus);
	}

	@Test
	public static void originTest() throws Exception {
		final String USER_DIR = System.getProperty("user.dir");
		String file = USER_DIR + "/src/main/java/cn/onlyfm/utils/provider-keys/rsa_key_paire_pkcs8.pem";
		String pubfile = USER_DIR + "/src/main/java/cn/onlyfm/utils/provider-keys/rsa_public_key.pem";

		String signType = "SHA1WithRSA";
		final PrivateKey privateKey = RSAUtils.loadPrivateKey(file);
		System.out.println(privateKey);

		final PublicKey publicKey = RSAUtils.loadPublicKey(pubfile);
		System.out.println(publicKey);

		String data = "{\"idCard\":\"370781398208290035\", \"name\": \"郝亮\", \"cardNo\": \"6227001217380029555\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}";
		System.out.println("-------------source:" + data);

		// 签名
		String sign = RSAUtils.sign(signType, data.getBytes("utf-8"), privateKey);
		System.out.println("-------------sign:" + sign);

		// 验签
		boolean signOK = RSAUtils.verifySign(signType, data.getBytes("utf-8"), publicKey, sign);
		System.out.println("-------------signOK:" + signOK);

		long start = System.currentTimeMillis();
		// 公钥加密
		String enc = RSAUtils.encryptByPublicKey(data, publicKey, "utf-8");
		System.out.println("-------------enc:" + enc);

		// 私钥解密
		String back = RSAUtils.decryptByPrivateKey(enc, privateKey, "utf-8");
		System.out.println("back:" + back);

		// 私钥加密
		String enc2 = RSAUtils.encryptByPrivateKey(data, privateKey, "utf-8");
		System.out.println("-------------enc2:" + enc2);

		// 公钥解密
		String back2 = RSAUtils.decryptByPublicKey(enc2, publicKey, "utf-8");
		System.out.println("back2:" + back2);

		long stop = System.currentTimeMillis();
		System.out.println("-----------done:" + (stop - start) / 1000);
	}

	@Test
	public void bankcardVerify3() throws Exception {
		String data = "";
		List<String> datas = new ArrayList<String>();
		datas.add("{\"idCard\":\"360222199304265625\", \"name\": \"占巧雯\", \"cardNo\": \"6214852105160736\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:UNDEAL
		datas.add("{\"idCard\":\"431124199205275182\", \"name\": \"李思静\", \"cardNo\": \"6214832162570753\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:UNDEAL
		datas.add("{\"idCard\":\"431124199205275189\", \"name\": \"李思静\", \"cardNo\": \"6214832162570750\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:UNDEAL
		datas.add("{\"idCard\":\"431124199205275189\", \"name\": \"李静\", \"cardNo\": \"6214832162570753\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:SUCCESS
		datas.add("{\"idCard\":\"431124199205275189\", \"name\": \"李思静\", \"cardNo\": \"6214832162570753\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:SUCCESS
		datas.add("{\"idCard\":\"310115198512231929\", \"name\": \"宋琳琳\", \"cardNo\": \"6217001180017302327\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// {
		// 	"error":"E080100009",
		// 	"msg":"银行卡为空",
		// 	"status":"0"
		// }
		datas.add("{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\", \"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望成功
		datas.add("{\"idCard\":\"370783198208290035\", \"name\": \"郝亮\", \"cardNo\": \"6227001217380029555\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望SUCCESS
		datas.add("{\"idCard\":\"340621198509176631\", \"name\": \"周圣总\", \"cardNo\": \"5187180010390916\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 期望:SUCCESS
		datas.add("{\"idCard\":\"37021119900722001X\", \"name\": \"孙敬璐\", \"cardNo\": \"6217002390017810992\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		// 线上测试
		datas.add("{\"idCard\":\"37021119900722001X\", \"name\": \"孙璐\", \"cardNo\": \"6217002390017810992\",\"orgCode\":\"coin01\",\"channelCode\":\"coin01\"}");

		final String SELF_PRI_KEY = "src/main/java/cn/onlyfm/utils/rsa_key_paire_pkcs8.pem";
		final String PROVIDER_PUB_KEY = "src/main/java/cn/onlyfm/utils/provider-keys/rsa_public_key.pem";
		final String SELF_PUB_KEY = "src/main/java/cn/onlyfm/utils/rsa_public_key.pem";
		final String USER_DIR = System.getProperty("user.dir");
		String signType = "SHA1WithRSA";
		final PrivateKey selfPrivateKey = RSAUtils.loadPrivateKey(USER_DIR + "/" + SELF_PRI_KEY);
		final PublicKey providerPublicKey = RSAUtils.loadPublicKey(USER_DIR + "/" + PROVIDER_PUB_KEY);

		for (int i = 0; i < datas.size(); i++) {
			data = datas.get(i);
			System.out.println("==================================================\n" + data);
			JSONObject jsonObject = JSONObject.parseObject(data);
			// System.out.print("curl -k -X POST http://localhost:9130/prpcredit/api.do?forward=api/1.0.0/out/bankcard/verify3 -d'");
			// System.out.print("curl -k -X POST http://alpha-101:9130/prpcredit/api.do?forward=api/1.0.0/out/bankcard/verify3 -d'");
			// System.out.print("curl -k -X POST https://openapi-demo.crephet.com/prpcredit/api/1.0.0/out/bankcard/verify3 -d'");
			System.out.print("curl -k -X POST https://openapi.crephet.com/prpcredit/api/1.0.0/out/bankcard/verify3 -d'");
			System.out.print("orgCode=" + jsonObject.get("orgCode"));
			System.out.print("&channelCode=" + jsonObject.get("channelCode"));
			String signStr = RSAUtils.sign(signType, data.getBytes("utf-8"), selfPrivateKey);
			System.out.print("&sign=" + signStr);
			String reqData = RSAUtils.encryptByPublicKey(data, providerPublicKey, "utf-8"); //公钥加密并base64编码
			System.out.println("&reqData=" + reqData + "'");
		}

		String respSign = "CKkSkLoR1YHQprlfe3ajplxSh5mtlASYoo9a4eIkyvpy7rZHKhnYafuPdTPGwQ1XiZ+JoLEhQNlAlt89+00Xqe+rNSz7KZ38xvNofnwKmrF1nIeWaP/riXkHzWLygjbUalrVotvJAJcLxn2X2tZLA4OpAmqePIYz1kSfaa/RPOI=";
		String respData = "KpN+bx00X8RrroAt5U+lsi5PJ6a3Q/qmSvJNusKL1r+gIF3SPbrAWgho1SHtSLbKupHfyDVNkCAP0A51XN/jlYgiIla09sG/Ooo4x8aU0OdPh46vln00uCNCDwdJlzcwXg22c+4nMRf1FQsWw6NmX+/DhTkJgDOCQf40BXCKDsRQ4hhV6VhMFZ0wKekID7y7TFPEqL/qMmsVuf8buTUSXEUaPE7wCOdRsPpZUmHgER9iUrSdWpntBMoK4gMh+Q21HmlR377lhJbMG51PLXqJTqAT+xpA740tlzw3/yq3PrkOLP09SybyAz0cy02Q1sqXa5RxvZtGMgZHVDx9SWnfnw==";

		String decryptedJson = RSAUtils.decryptByPrivateKey(respData, selfPrivateKey, "utf-8");
		System.out.println(decryptedJson);
		boolean respSignStatus = RSAUtils.verifySign(signType, decryptedJson.getBytes("utf-8"), providerPublicKey, respSign);
		System.out.println("验签:" + respSignStatus);
	}

	@Test void realnameVerify() throws Exception{
		List<String> datas = new ArrayList<String>();

		datas.add("{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		datas.add("{\"idCard\":\"420211199008240097 \", \"name\": \"陈都\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000011\"}");
		datas.add("{\"idCard\":\"420211199008240097 \", \"name\": \"陈都\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		datas.add("{\"idCard\":\"420111199008240097 \", \"name\": \"陈都都\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");
		datas.add("{\"idCard\":\"420111199008240097 \", \"name\": \"陈都\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");

		final String SELF_PRI_KEY = "src/main/java/cn/onlyfm/utils/rsa_key_paire_pkcs8.pem";
		final String PROVIDER_PUB_KEY = "src/main/java/cn/onlyfm/utils/provider-keys/rsa_public_key.pem";
		final String USER_DIR = System.getProperty("user.dir");
		String signType = "SHA1WithRSA";
		final PrivateKey selfPrivateKey = RSAUtils.loadPrivateKey(USER_DIR + "/" + SELF_PRI_KEY);
		final PublicKey providerPublicKey = RSAUtils.loadPublicKey(USER_DIR + "/" + PROVIDER_PUB_KEY);

		for (int i = 0; i < datas.size(); i++) {
			String data = datas.get(i);
			System.out.println("==================================================\n" + data);
			JSONObject jsonObject = JSONObject.parseObject(data);
			// System.out.print("curl -k -X POST http://localhost:9130/prpcredit/api.do?forward=api/1.0.0/out/realname/verification -d'");
			// System.out.print("curl -k -X POST http://alpha-101:9130/prpcredit/api.do?forward=api/1.0.0/out/realname/verification -d'");
			System.out.print("curl -k -X POST https://openapi-demo.crephet.com/prpcredit/api/1.0.0/out/realname/verification -d'");
			System.out.print("orgCode=" + jsonObject.get("orgCode"));
			System.out.print("&channelCode=" + jsonObject.get("channelCode"));
			String signStr = RSAUtils.sign(signType, data.getBytes("utf-8"), selfPrivateKey);
			System.out.print("&sign=" + signStr);
			String reqData = RSAUtils.encryptByPublicKey(data, providerPublicKey, "utf-8"); //公钥加密并base64编码
			System.out.println("&reqData=" + reqData + "'");
		}

		String respSign = "KcQXU/M9gRA2QMh7nmW8gbsI6RbqOYGl2tdq/GHNtqCdr/9MFTBoeIfq99T5Nj4v9EW5GUV8olxbMG3stOId9aseAG/yhmOu3StXwHIY18lFGki9u4WiaGVjSF25RXzYS5nqABagfMM0JtrzTXXghlcSFjQK4POkEKAoRkT0ZPQ=";
		String respData = "mYm85Pl89VWK3Y2OJWuow7uF7nd9RMfznHA2qxuiTr28kQSruqxm+90ri693kdy2xKHmYKy7SIjJLYcuy0WqPMsVQZW8RySAst5Xt1kpRJc29zf5BySg+1P1zuQ2qJxbnNykxoNcR8SALn2f5p2XBS+0fHk4JcOe6WicNPqTqfpCQBcOskxBnGs1hXwEuX++M/fs/VQG2ozPa9r9GAwVcktpMWtq/tr4zfwBQJwrNVA5rGcc7fhJjTYhMe9qpz/CxGzLVQff7KCAgIYfEAUPx1RD0A6iztCEXG76A9tfp6ctreDcWCLjuQU24F8HG9ydETMjXjcn1VjgFRxSLKYIyA==";

		String decryptedJson = RSAUtils.decryptByPrivateKey(respData, selfPrivateKey, "utf-8");
		System.out.println(decryptedJson);
		boolean respSignStatus = RSAUtils.verifySign(signType, decryptedJson.getBytes("utf-8"), providerPublicKey, respSign);
		System.out.println("验签:" + respSignStatus);
	}

	@Test void mobileVerify3() throws Exception{
		List<String> datas = new ArrayList<String>();

		datas.add("{\"idCard\":\"421302199202081224\", \"name\": \"成娓\",\"phone\":\"17717550328\",\"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}");

		final String SELF_PRI_KEY = "src/main/java/cn/onlyfm/utils/rsa_key_paire_pkcs8.pem";
		final String PROVIDER_PUB_KEY = "src/main/java/cn/onlyfm/utils/provider-keys/rsa_public_key.pem";
		final String USER_DIR = System.getProperty("user.dir");
		String signType = "SHA1WithRSA";
		final PrivateKey selfPrivateKey = RSAUtils.loadPrivateKey(USER_DIR + "/" + SELF_PRI_KEY);
		final PublicKey providerPublicKey = RSAUtils.loadPublicKey(USER_DIR + "/" + PROVIDER_PUB_KEY);

		for (int i = 0; i < datas.size(); i++) {
			String data = datas.get(i);
			System.out.println("==================================================\n" + data);
			JSONObject jsonObject = JSONObject.parseObject(data);
			// System.out.print("curl -k -X POST http://localhost:9130/prpcredit/api.do?forward=api/1.0.0/out/mobile/verify -d'");
			// System.out.print("curl -k -X POST http://alpha-101:9130/prpcredit/api.do?forward=api/1.0.0/out/mobile/verify -d'");
			System.out.print("curl -k -X POST https://openapi-demo.crephet.com/prpcredit/api/1.0.0/out/mobile/verify -d'");
			System.out.print("orgCode=" + jsonObject.get("orgCode"));
			System.out.print("&channelCode=" + jsonObject.get("channelCode"));
			String signStr = RSAUtils.sign(signType, data.getBytes("utf-8"), selfPrivateKey);
			System.out.print("&sign=" + signStr);
			String reqData = RSAUtils.encryptByPublicKey(data, providerPublicKey, "utf-8"); //公钥加密并base64编码
			System.out.println("&reqData=" + reqData + "'");
		}

		String respSign = "Sy80AHXwmrp0PsAjQrAF7GNGHEFUnvnTlbp8w8aCUVqoQYM7bKGqSGYxvvwL1KLFZM9NLmlAxaw7P6FeEBNkFcdQ5PQNJN4lSqSraKgDYD1g3v+/9tvFrjkJk0s5JHrhKKkoedPHQD9UahE+3PLpeU5eVjaf4CE/mM1yq6iyauk=";
		String respData = "QDKV1mRm5RhNz27u9cqt375nuMgsRYzZMd5c8IGy5F8qANObn4Z05RkQCgxXYGvae4swKGn/eupXoBRxiNYoUcOzRQgPqqQkb0Eub3LPa0qVBpQcuLFpGusFT32YETvl6jEdnDmAWewlHZc6lfMTlUqSHfgTnUVeEgdoD4EtnOU=";

		String decryptedJson = RSAUtils.decryptByPrivateKey(respData, selfPrivateKey, "utf-8");
		System.out.println(decryptedJson);
		boolean respSignStatus = RSAUtils.verifySign(signType, decryptedJson.getBytes("utf-8"), providerPublicKey, respSign);
		System.out.println("验签:" + respSignStatus);
	}
}
