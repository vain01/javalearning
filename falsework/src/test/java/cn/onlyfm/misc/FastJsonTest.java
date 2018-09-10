package cn.onlyfm.misc;

import cn.onlyfm.misc.campaign.CampaignConfiguration;
import cn.onlyfm.misc.campaign.CampaignTaskData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author haoliang on 2018/8/1.
 */
public class FastJsonTest {
	@Test
	public void testJsonObject() {
		String jsonStr = "{\"idCard\":\"421302199202081224\", \"name\": \"成娓娓\", \"orgCode\":\"haoliang\",\"channelCode\":\"CH000044\"}";
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		System.out.println(jsonObject.get("idCard"));
		System.out.println(jsonObject.toJSONString());
		System.out.println(new JSONObject().toJSONString());
	}

	@Test
	public void testJsonArray() {
		String jsonStr = "[{\"step\":1,\"startTime\":11111,\"endTime\":222,\"url\":\"33\",\"pageSize\":\"33\"},{\"step\":1,\"c\":\"33\"}]";
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		System.out.println(jsonArray);
		System.out.println(jsonArray.toString());
		System.out.println(jsonArray.size());
		System.out.println(jsonArray.get(0));
		// JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(jsonArray.get(0)));
		JSONObject jsonObject = JSON.parseObject(jsonArray.get(0).toString());
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject.get("url"));
	}

	@Test
	public void testCampaign() {
		String yyy = "[{\"campaignId\":33333,\"config\":[{\"name\":\"冲顶结束时间，补满人数\",\"startTime\":152223333,\"endTime\":152223333,\"url\":\"http://host/prpcampaign/api/1.0.0/sprint/operateData\",\"data\":{\"campaignId\":33333}},{\"name\":\"冲顶成功发短信\",\"startTime\":152223333,\"endTime\":152223333,\"url\":\"http://host/prpcampaign/api/1.0.0/sprint/operateData\",\"data\":{\"campaignId\":3333}},{\"name\":\"分配红包\",\"startTime\":152223333,\"endTime\":152223333,\"url\":\"http://host/prpcampaign/api/1.0.0/sprint/operateData\",\"data\":{\"campaignId\":33333}},{\"name\":\"红包分配成功，发送短信\",\"startTime\":152223333,\"endTime\":152223333,\"url\":\"http://host/prpcampaign/api/1.0.0/sprint/operateData\",\"data\":{\"campaignId\":33333}},{\"name\":\"批量生产分享图片\",\"startTime\":152223333,\"endTime\":152223333,\"url\":\"http://host/prpcampaign/api/1.0.0/sprint/operateData\",\"data\":{\"campaignId\":33333,\"pageSize\":100}}]}]";
		try {
			List<CampaignConfiguration> campaignConfigurations = JSONArray.parseArray(yyy, CampaignConfiguration.class);
			System.out.println(campaignConfigurations);
			System.out.println(campaignConfigurations.get(0));
			System.out.println(campaignConfigurations.get(0).getCampaignId());
			System.out.println(campaignConfigurations.get(0).getConfig());
			System.out.println(campaignConfigurations.get(0).getConfig().get(0));
			System.out.println(campaignConfigurations.get(0).getConfig().get(0).getData());
			System.out.println(campaignConfigurations.get(0).getConfig().get(0).getData());
			CampaignTaskData a = campaignConfigurations.get(0).getConfig().get(0).getData();
			System.out.println(a);
			System.out.println(JSON.toJSONString(campaignConfigurations.get(0).getConfig().get(0).getData()));
			System.out.println(JSON.toJSONString(campaignConfigurations));
			Date d= new Date();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(df.format(d));
			Thread.sleep(1000);
			Long now = System.currentTimeMillis();
			d.setTime(now);
			System.out.println(df.format(d));
			System.out.println(df.format(new Date(now)));
			System.out.println(df.format(new Date(1532620800000L)));
			int aint = 9;
			Integer b = 88;
			System.out.println(aint>b);
			Long c=777L;
			System.out.println(c+2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
