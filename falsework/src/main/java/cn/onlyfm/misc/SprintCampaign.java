package cn.onlyfm.misc;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author haoliang on 2018/7/30.
 */
@Data
public class SprintCampaign {
	private Long merchantId;
	private String name;
	private String rule;
	private int userCount;
	private Long beginTime;
	private Long endTime;
	private Long lotteryBeginTime;
	private Long lotteryEndTime;
	private BigDecimal total;
	private String description;
	private int enabled;

	private Integer type;
	private String registerUrl;
	private String downloadUrl;
	private String landingpageStyle;
}
