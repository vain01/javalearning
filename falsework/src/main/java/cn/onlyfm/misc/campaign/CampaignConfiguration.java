package cn.onlyfm.misc.campaign;

import lombok.Data;

import java.util.List;

/**
 * @author haoliang on 2018/8/1.
 */
@Data
public class CampaignConfiguration {
	private Long campaignId;
	private List<CampaignTask> config;
}
