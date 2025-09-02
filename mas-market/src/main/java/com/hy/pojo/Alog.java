package com.hy.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Alog {
    //CPM=花费/曝光次数*1000
    private BigDecimal cpm;

    //月活会员ROI=月活会员GMV/花费
    private BigDecimal roi;

    //月活会员CAC=花费/月活会员数
    private BigDecimal cac;

    //月活会员贡献率(Monthly Active Member Contribution Rate)=月活会员数/周期月活人数
    private BigDecimal mamcRate;

    //月活会员GMV贡献率=月活会员GMV/周期月活GMV
    private BigDecimal mamcGmvRate;

    //拉新会员ROI=拉新会员GMV/花费
    private BigDecimal rnmRoi;

    //拉新会员CAC=花费/拉新会员数
    private BigDecimal rnmCac;

    //拉新会员贡献率(New Member Contribution Rate)=拉新会员数/周期月活人数
    private BigDecimal nmcRate;

    //拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    private BigDecimal nmcGmvRate;

    //活动期人均月活GMV=月活会员GMV/月活会员数
    private BigDecimal pcmaGmv;

    //次月人均月活GMV=次月月活会员GMV/次月月活会员数
    private BigDecimal mpcmaGmv;

    //活动期人均拉新GMV=拉新会员GMV/拉新会员数
    private BigDecimal pcnGmv;

    //次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    private BigDecimal panGmv;

    //月活次月留存率=次月月活会员数/月活会员数
    private BigDecimal masmrRate;

    //拉新次月留存率=次月拉新会员数/拉新会员数
    private BigDecimal mrrrRate;

}
