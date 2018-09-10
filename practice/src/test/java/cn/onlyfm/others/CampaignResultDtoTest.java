package cn.onlyfm.others;

import com.alibaba.fastjson.JSONArray;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author haoliang on 2018/8/8.
 */
public class CampaignResultDtoTest {
	@Test
	public void testName() {
		String campaignResultJsonStr = "[{\"registerMobile\":\"13482892311\",\"registerMobi5le\":\"13482892311\",\"registerTime\":1538888899999},{\"registerMobile\":\"13482892312\",\"registerTime\":1538888899998},{\"registerMobile\":\"13482892313\",\"registerTime\":1538888899997},{\"registerMobile\":\"13482892313\",\"registerTime\":1538888899997}]";
		List<CampaignResultFullDto> CampaignResultFullDtoList = JSONArray.parseArray(campaignResultJsonStr, CampaignResultFullDto.class);
		for (CampaignResultFullDto item :
			CampaignResultFullDtoList) {
			System.out.println(item);
			if(item.getCampaignId() ==null){
				item.setCampaignId(99L);
			}

		}
		System.out.println(CampaignResultFullDtoList);
	}
}
