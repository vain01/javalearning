package cn.onlyfm.misc;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/7/30.
 */
public class SprintCampaignTest {
	@Test
	public void test() {
		SprintCampaign sprintCampaign = new SprintCampaign();
		System.out.println(sprintCampaign.getUserCount());
		System.out.println(sprintCampaign.getEnabled());
		System.out.println(sprintCampaign.getDescription());

		Map<String, String> sprintPrizeAmountInfo = new HashMap<>();
		sprintPrizeAmountInfo.put("BigDecimal",new BigDecimal("22").toString());
		sprintPrizeAmountInfo.put("Integer",new Integer("22").toString());
		sprintPrizeAmountInfo.put("Long",new Long("22").toString());
		String jsonStr = JSONObject.toJSONString(sprintPrizeAmountInfo);
		System.out.println(jsonStr);
	}
}
