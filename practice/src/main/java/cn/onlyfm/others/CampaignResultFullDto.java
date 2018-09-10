package cn.onlyfm.others;

import lombok.Data;

import java.util.UUID;

/**
 * @author haoliang on 2018/8/8.
 */
@Data
public class CampaignResultFullDto {
	private String requestId = "srpint" + UUID.randomUUID();
	private Long campaignId;
	private String registerMobile;
	private Long registerTime;
	private Integer registerResult = 1;
}
