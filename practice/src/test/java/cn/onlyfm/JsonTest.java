package cn.onlyfm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/9/20.
 */
public class JsonTest {
	@Test
	public void testJSONObjectMap() {
		Map<String, String> testing = new HashMap<>();
		testing.put("a", "asdf");
		testing.put("b", "eee");
		Object testingObj = testing;
		JSONObject parsedObj = JSONObject.parseObject(JSON.toJSONString(testingObj));
		System.out.println(parsedObj.get("a"));
	}

	@Test
	public void testJSONtoString() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 44);
		map.put("b", 445);
		String str = JSON.toJSONString(map);
		System.out.println(str);
	}

	@Test
	public void testName() {
		String origin = "{\"dailyRedPackageMaxAmount\":500,\"bamboomatTotalQuantity\":5}";
		JSONObject originJsonObject = JSON.parseObject(origin);
		System.out.println(originJsonObject);

		Object originObj = origin;
		JSONObject jsonObject = JSON.parseObject(originObj.toString());
		System.out.println(jsonObject);

	}

	@Test
	public void testJSONArray() {
		String ori = "{\"result_list\":[{\"category_id\":\"50012019\",\"category_name\":\"旅行箱\",\"commission_rate\":\"2000\",\"coupon_end_time\":\"2018-10-31\",\"coupon_id\":\"35c086b5435a4e4b9360a858fc7f300a\",\"coupon_info\":\"满199.00元减110元\",\"coupon_remain_count\":\"94000\",\"coupon_start_time\":\"2018-10-25\",\"coupon_total_count\":\"100000\",\"item_url\":\"https:\\\\/\\\\/detail.tmall.com\\\\/item.htm?id=569465429363\",\"level_one_category_id\":\"50006842\",\"level_one_category_name\":\"箱包皮具\\\\/热销女包\\\\/男包\",\"num_iid\":\"569465429363\",\"pict_url\":\"https:\\\\/\\\\/img.alicdn.com\\\\/bao\\\\/uploaded\\\\/i2\\\\/3116599366\\\\/O1CN012J3g1Is3FvKbFRv_!!0-item_pic.jpg\",\"provcity\":\"上海\",\"reserve_price\":\"1099\",\"seller_id\":\"3116599366\",\"shop_dsr\":\"48127\",\"shop_title\":\"卡帝乐鳄鱼嘉聚专卖店\",\"short_title\":\"卡帝乐鳄鱼男女密码万向轮拉杆箱\",\"small_images\":[\"https:\\\\/\\\\/img.alicdn.com\\\\/i1\\\\/3116599366\\\\/O1CN012J3g1DurryBA1JZ_!!3116599366.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i4\\\\/3116599366\\\\/O1CN012J3g1FGoOksXrwG_!!3116599366.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i3\\\\/3116599366\\\\/O1CN012J3g1HuKFxevjcB_!!3116599366.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i2\\\\/3116599366\\\\/TB2jjtBqsj_B1NjSZFHXXaDWpXa_!!3116599366.jpg\"],\"title\":\"卡帝乐鳄鱼旅行箱男女学生密码拉杆箱万向轮24寸登机皮箱子行李箱\",\"tk_total_commi\":\"1.37781e+06\",\"tk_total_sales\":\"51907\",\"user_type\":\"1\",\"volume\":\"99255\",\"white_image\":\"https:\\\\/\\\\/img.alicdn.com\\\\/bao\\\\/uploaded\\\\/TB18JkCizDpK1RjSZFrwu178VXa.png\",\"zk_final_price\":\"199\"},{\"category_id\":\"50012019\",\"category_name\":\"旅行箱\",\"commission_rate\":\"2000\",\"coupon_end_time\":\"2018-10-26\",\"coupon_id\":\"bd4be3f76f6049a581df4020025ed524\",\"coupon_info\":\"满199.00元减110元\",\"coupon_remain_count\":\"88000\",\"coupon_start_time\":\"2018-10-21\",\"coupon_total_count\":\"100000\",\"item_url\":\"https:\\\\/\\\\/detail.tmall.com\\\\/item.htm?id=567402289114\",\"level_one_category_id\":\"50006842\",\"level_one_category_name\":\"箱包皮具\\\\/热销女包\\\\/男包\",\"num_iid\":\"567402289114\",\"pict_url\":\"https:\\\\/\\\\/img.alicdn.com\\\\/bao\\\\/uploaded\\\\/i1\\\\/3229147608\\\\/TB2y15FwmMmBKNjSZTEXXasKpXa_!!3229147608-0-item_pic.jpg\",\"provcity\":\"浙江 温州\",\"reserve_price\":\"1099\",\"seller_id\":\"3229147608\",\"shop_dsr\":\"48072\",\"shop_title\":\"卡帝乐鳄鱼葵轩专卖店\",\"short_title\":\"卡帝乐鳄鱼男女密码万向轮拉杆箱\",\"small_images\":[\"https:\\\\/\\\\/img.alicdn.com\\\\/i2\\\\/3229147608\\\\/TB2mfdmwkZmBKNjSZPiXXXFNVXa_!!3229147608.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i3\\\\/3229147608\\\\/TB24JAbycyYBuNkSnfoXXcWgVXa_!!3229147608.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i2\\\\/3229147608\\\\/TB2HYyfajfguuRjSszcXXbb7FXa_!!3229147608.jpg\",\"https:\\\\/\\\\/img.alicdn.com\\\\/i3\\\\/3229147608\\\\/TB2nBwrHamWBuNjy1XaXXXCbXXa_!!3229147608.jpg\"],\"title\":\"卡帝乐鳄鱼行李箱男女学生密码拉杆箱万向轮24寸登机旅行箱皮箱子\",\"tk_total_commi\":\"285290\",\"tk_total_sales\":\"9657\",\"user_type\":\"1\",\"volume\":\"13230\",\"white_image\":\"https:\\\\/\\\\/img.alicdn.com\\\\/bao\\\\/uploaded\\\\/TB1WMTPiNjaK1RjSZFAwu2dLFXa.png\",\"zk_final_price\":\"199\"}],\"total_results\":\"18416\"}";

		JSONObject xx = JSON.parseObject(ori);
		System.out.println(xx.get("result_list"));
	}
}
