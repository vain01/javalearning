package cn.onlyfm.others;

import lombok.Data;

/**
 * Create by qidong on 2018/5/16.
 */
@Data
public class SprintJoinRecord {

    private String requestId;
    private Long campaignId;
    private Long userId;
    private String mobile;
    private String registerMobile;
    private Long registerTime;
    private int registerResult;
    private String addProduct;
    private String addChannel;
    private String devicePlatform;
    private String ip;
    private String marketChannel;
    private String productVersion;

}