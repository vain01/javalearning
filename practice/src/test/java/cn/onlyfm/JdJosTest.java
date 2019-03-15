package cn.onlyfm;

import cn.onlyfm.utils.JdJosUtil;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/3/8.
 */
public class JdJosTest {
	@Test
	public void testName() {
		/*
https://api.jd.com/routerjson
?v=2.0
&method=jingdong.union.search.queryCouponGoods
&app_key=6FD5C55CED97CE65760A7A2C49F2D7E5
&access_token=ece3b6ab1c8b87a79b200006ac80b2584ab49ec0f1655dd7b65d38a5ed67d712bd1f8814bd47e2ae
&360buy_param_json={"skuIdList":"","pageIndex":"","pageSize":"","cid3":"","goodsKeyword":"","priceFrom":"","priceTo":""}
&timestamp=2019-03-08 11:52:15
&sign=E867762D5572075D6FB15CA823061B63
		 */
		String v = "2.0";
		String method = "jingdong.union.search.queryCouponGoods";
		String appKey = "6FD5C55CED97CE65760A7A2C49F2D7E5";
		String accessToken = "ece3b6ab1c8b87a79b200006ac80b2584ab49ec0f1655dd7b65d38a5ed67d712bd1f8814bd47e2ae";
		String paramJson = "{\"skuIdList\":\"\",\"pageIndex\":\"\",\"pageSize\":\"\",\"cid3\":\"\",\"goodsKeyword\":\"\",\"priceFrom\":\"\",\"priceTo\":\"\"}";
		String timestamp = "2019-03-08 11:52:15";
		String appSecret = "45ea42c89a924aefaaa1110fc340110c";

		try {
			String sign = JdJosUtil.buildSign(timestamp, v, method, paramJson, accessToken, appKey, appSecret);
			System.out.println("sign:{}." + sign);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
