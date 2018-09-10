package cn.onlyfm.misc.campaign;

import lombok.Data;

/**
 * @author haoliang on 2018/8/1.
 */
@Data
public class CampaignTask {
	private String name;
	private String url;
	private Integer status; //0:需要执行 1:不需执行
	private Integer pageSize;
	private CampaignTaskData data;
}
