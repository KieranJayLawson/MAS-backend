package com.hy.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AlogDiff {
    //CPM=花费/曝光次数*1000
    private BigDecimal cpmDiff;

    //月活会员ROI=月活会员GMV/花费
    private BigDecimal roiDiff;

    //月活会员CAC=花费/月活会员数
    private BigDecimal cacDiff;

    //月活会员贡献率(Monthly Active Member Contribution Rate)=月活会员数/周期月活人数
    private BigDecimal mamcRateDiff;

    //月活会员GMV贡献率=月活会员GMV/周期月活GMV
    private BigDecimal mamcGmvRateDiff;

    //拉新会员ROI=拉新会员GMV/花费
    private BigDecimal rnmRoiDiff;

    //拉新会员CAC=花费/拉新会员数
    private BigDecimal rnmCacDiff;

    //拉新会员贡献率(New Member Contribution Rate)=拉新会员数/周期月活人数
    private BigDecimal nmcRateDiff;

    //拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    private BigDecimal nmcGmvRateDiff;

    //活动期人均月活GMV=月活会员GMV/月活会员数
    private BigDecimal pcmaGmvDiff;

    //次月人均月活GMV=次月月活会员GMV/次月月活会员数
    private BigDecimal mpcmaGmvDiff;

    //活动期人均拉新GMV=拉新会员GMV/拉新会员数
    private BigDecimal pcnGmvDiff;

    //次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    private BigDecimal panGmvDiff;

    //月活次月留存率=次月月活会员数/月活会员数
    private BigDecimal masmrRateDiff;

    //拉新次月留存率=次月拉新会员数/拉新会员数
    private BigDecimal mrrrRateDiff;

    private BigDecimal costDiff;

    private BigDecimal monitorRateDiff;

    private Long exposureCountDiff;

    private Long exposureUserCountDiff;

    private Long clickCountDiff;

    private Long clickUserCountDiff;

    private Long monthlyActiveMemberCountDiff;

    private BigDecimal monthlyActiveMemberGmvDiff;

    private Long newMemberAcquisitionCountDiff;

    private BigDecimal newMemberAcquisitionGmvDiff;

    private Long periodicMonthlyActiveUserCountDiff;

    private BigDecimal periodicMonthlyActiveUserGmvDiff;

    private Long periodicNewMemberCountDiff;

    private BigDecimal periodicNewMemberGmvDiff;

    private Long nextMonthActiveMemberCountDiff;

    private BigDecimal nextMonthActiveMemberGmvDiff;

    private Long nextMonthNewMemberCountDiff;

    private BigDecimal nextMonthNewMemberGmvDiff;

}
