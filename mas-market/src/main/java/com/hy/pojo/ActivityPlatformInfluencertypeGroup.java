package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ActivityPlatformInfluencertypeGroup {
    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("媒介")
    private String media;

    @ExcelProperty("达人类型")
    private String talentType;

    @ExcelProperty("花费")
    private BigDecimal cost;

    @ExcelProperty("曝光次数")
    private Long exposureCount;

    @ExcelProperty("曝光人数")
    private Long exposureUserCount;

    @ExcelProperty("平均曝光频率")
    private BigDecimal avgImpressionFrequency;

    @ExcelProperty("点击次数")
    private Long clickCount;

    @ExcelProperty("点击人数")
    private Long clickUserCount;

    @ExcelProperty("月活会员数")
    private Long monthlyActiveMemberCount;

    @ExcelProperty("月活会员GMV")
    private BigDecimal monthlyActiveMemberGmv;

    @ExcelProperty("拉新会员数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("拉新会员GMV")
    private BigDecimal newMemberAcquisitionGmv;

    @ExcelProperty("次月月活会员数")
    private Long nextMonthActiveMemberCount;

    @ExcelProperty("次月月活会员GMV")
    private BigDecimal nextMonthActiveMemberGmv;

    @ExcelProperty("次月拉新会员数")
    private Long nextMonthNewMemberCount;

    @ExcelProperty("次月拉新会员GMV")
    private BigDecimal nextMonthNewMemberGmv;

    //CPM=花费/曝光次数*1000
    @ExcelProperty("CPM")
    private BigDecimal cpm;

    //月活会员ROI=月活会员GMV/花费
    @ExcelProperty("月活会员ROI")
    private BigDecimal roi;

    //月活会员CAC=花费/月活会员数
    @ExcelProperty("月活会员CAC")
    private BigDecimal cac;

    //月活会员贡献率(Monthly Active Member Contribution Rate)=月活会员数/周期月活人数
    @ExcelProperty("月活会员贡献率")
    private BigDecimal mamcRate;

    //月活会员GMV贡献率=月活会员GMV/周期月活GMV
    @ExcelProperty("月活会员GMV贡献率")
    private BigDecimal mamcGmvRate;

    //拉新会员ROI=拉新会员GMV/花费
    @ExcelProperty("拉新会员ROI")
    private BigDecimal rnmRoi;

    //拉新会员CAC=花费/拉新会员数
    @ExcelProperty("拉新会员CAC")
    private BigDecimal rnmCac;

    //拉新会员贡献率(New Member Contribution Rate)=拉新会员数/周期月活人数
    @ExcelProperty("拉新会员贡献率")
    private BigDecimal nmcRate;

    //拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    @ExcelProperty("拉新会员GMV贡献率")
    private BigDecimal nmcGmvRate;

    //活动期人均月活GMV=月活会员GMV/月活会员数
    @ExcelProperty("活动期人均月活GMV")
    private BigDecimal pcmaGmv;

    //次月人均月活GMV=次月月活会员GMV/次月月活会员数
    @ExcelProperty("次月人均月活GMV")
    private BigDecimal mpcmaGmv;

    //活动期人均拉新GMV=拉新会员GMV/拉新会员数
    @ExcelProperty("活动期人均拉新GMV")
    private BigDecimal pcnGmv;

    //次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    @ExcelProperty("次月人均拉新GMV")
    private BigDecimal panGmv;

    //月活次月留存率=次月月活会员数/月活会员数
    @ExcelProperty("月活次月留存率")
    private BigDecimal masmrRate;

    //拉新次月留存率=次月拉新会员数/拉新会员数
    @ExcelProperty("拉新次月留存率")
    private BigDecimal mrrrRate;
}