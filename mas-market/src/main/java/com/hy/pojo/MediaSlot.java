package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MediaSlot {
    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("媒介平台")
    private String media;

    @ExcelProperty("活动ID")
    private String campaignId;

    @ExcelProperty("开始时间")
    private Date startDate;

    @ExcelProperty("结束时间")
    private Date endDate;

    @ExcelProperty("花费")
    private BigDecimal cost;

    @ExcelProperty("曝光次数")
    private Long exposureCount;

    @ExcelProperty("曝光人数")
    private Long exposureUserCount;

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

    @ExcelProperty("花费占比值")
    private BigDecimal costAcc;
    @ExcelProperty("曝光次数占比值")
    private BigDecimal exposureCountAcc;
    @ExcelProperty("曝光人数占比值")
    private BigDecimal exposureUserCountAcc;
    @ExcelProperty("点击次数占比值")
    private BigDecimal clickCountAcc;
    @ExcelProperty("点击人数占比值")
    private BigDecimal clickUserCountAcc;
    @ExcelProperty("月活会员数占比值")
    private BigDecimal mamcAcc;
    @ExcelProperty("月活会员GMV占比值")
    private BigDecimal mamgcAcc;
    @ExcelProperty("拉新会员数占比值")
    private BigDecimal nmacAcc;
    @ExcelProperty("拉新会员Gmv占比值")
    private BigDecimal nmagAcc;
    @ExcelProperty("次月月活会员数占比值")
    private BigDecimal nmamcAcc;
    @ExcelProperty("次月月活Gmv占比值")
    private BigDecimal nmamgAcc;
    @ExcelProperty("次月拉新会员数占比值")
    private BigDecimal nmnmcAcc;
    @ExcelProperty("次月拉新Gmv占比值")
    private BigDecimal nmnmgAcc;

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

    //CPM=花费/曝光次数*1000
    @ExcelProperty("CPM历史均值")
    private BigDecimal cpmAvg;

    //月活会员ROI=月活会员GMV/花费
    @ExcelProperty("月活会员ROI历史均值")
    private BigDecimal roiAvg;

    //月活会员CAC=花费/月活会员数
    @ExcelProperty("月活会员CAC历史均值")
    private BigDecimal cacAvg;

    //月活会员贡献率(Monthly Active Member Contribution Rate)=月活会员数/周期月活人数
    @ExcelProperty("月活会员贡献率历史均值")
    private BigDecimal mamcRateAvg;

    //月活会员GMV贡献率=月活会员GMV/周期月活GMV
    @ExcelProperty("月活会员GMV贡献率历史均值")
    private BigDecimal mamcGmvRateAvg;

    //拉新会员ROI=拉新会员GMV/花费
    @ExcelProperty("拉新会员ROI历史均值")
    private BigDecimal rnmRoiAvg;

    //拉新会员CAC=花费/拉新会员数
    @ExcelProperty("拉新会员CAC历史均值")
    private BigDecimal rnmCacAvg;

    //拉新会员贡献率(New Member Contribution Rate)=拉新会员数/周期月活人数
    @ExcelProperty("拉新会员贡献率历史均值")
    private BigDecimal nmcRateAvg;

    //拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    @ExcelProperty("拉新会员GMV贡献率历史均值")
    private BigDecimal nmcGmvRateAvg;

    //活动期人均月活GMV=月活会员GMV/月活会员数
    @ExcelProperty("活动期人均月活GMV历史均值")
    private BigDecimal pcmaGmvAvg;

    //次月人均月活GMV=次月月活会员GMV/次月月活会员数
    @ExcelProperty("次月人均月活GMV历史均值")
    private BigDecimal mpcmaGmvAvg;

    //活动期人均拉新GMV=拉新会员GMV/拉新会员数
    @ExcelProperty("活动期人均拉新GMV历史均值")
    private BigDecimal pcnGmvAvg;

    //次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    @ExcelProperty("次月人均拉新GMV历史均值")
    private BigDecimal panGmvAvg;

    //月活次月留存率=次月月活会员数/月活会员数
    @ExcelProperty("月活次月留存率历史均值")
    private BigDecimal masmrRateAvg;

    //拉新次月留存率=次月拉新会员数/拉新会员数
    @ExcelProperty("拉新次月留存率历史均值")
    private BigDecimal mrrrRateAvg;

    //CPM=花费/曝光次数*1000
    @ExcelProperty("CPM差值")
    private BigDecimal cpmDiff;

    //月活会员ROI=月活会员GMV/花费
    @ExcelProperty("月活会员ROI差值")
    private BigDecimal roiDiff;

    //月活会员CAC=花费/月活会员数
    @ExcelProperty("月活会员CAC差值")
    private BigDecimal cacDiff;

    //月活会员贡献率(Monthly Active Member Contribution Rate)=月活会员数/周期月活人数
    @ExcelProperty("月活会员贡献率差值")
    private BigDecimal mamcRateDiff;

    //月活会员GMV贡献率=月活会员GMV/周期月活GMV
    @ExcelProperty("月活会员GMV贡献率差值")
    private BigDecimal mamcGmvRateDiff;

    //拉新会员ROI=拉新会员GMV/花费
    @ExcelProperty("拉新会员ROI差值")
    private BigDecimal rnmRoiDiff;

    //拉新会员CAC=花费/拉新会员数
    @ExcelProperty("拉新会员CAC差值")
    private BigDecimal rnmCacDiff;

    //拉新会员贡献率(New Member Contribution Rate)=拉新会员数/周期月活人数
    @ExcelProperty("拉新会员贡献率差值")
    private BigDecimal nmcRateDiff;

    //拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    @ExcelProperty("拉新会员GMV贡献率差值")
    private BigDecimal nmcGmvRateDiff;

    //活动期人均月活GMV=月活会员GMV/月活会员数
    @ExcelProperty("活动期人均月活GMV差值")
    private BigDecimal pcmaGmvDiff;

    //次月人均月活GMV=次月月活会员GMV/次月月活会员数
    @ExcelProperty("次月人均月活GMV差值")
    private BigDecimal mpcmaGmvDiff;

    //活动期人均拉新GMV=拉新会员GMV/拉新会员数
    @ExcelProperty("活动期人均拉新GMV差值")
    private BigDecimal pcnGmvDiff;

    //次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    @ExcelProperty("次月人均拉新GMV差值")
    private BigDecimal panGmvDiff;

    //月活次月留存率=次月月活会员数/月活会员数
    @ExcelProperty("月活次月留存率差值")
    private BigDecimal masmrRateDiff;

    //拉新次月留存率=次月拉新会员数/拉新会员数
    @ExcelProperty("拉新次月留存率差值")
    private BigDecimal mrrrRateDiff;

}

