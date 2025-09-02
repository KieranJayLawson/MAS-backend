package com.hy.exceltemp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivityAlogAndDiffExcel {
    @ExcelProperty("活动名称")
    private String campaignName;
    @ExcelProperty("活动ID")
    private String campaignId;
    @ExcelProperty("活动开始时间")
    @ColumnWidth(value = 20)
    private Date startDate;
    @ExcelProperty("活动结束时间")
    @ColumnWidth(value = 20)
    private Date endDate;
    @ExcelProperty("活动花费")
    private BigDecimal cost;
    @ExcelProperty("监控比率")
    private BigDecimal monitorRate;
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
    @ExcelProperty("周期月活人数")
    private Long periodicMonthlyActiveUserCount;
    @ExcelProperty("周期月活GMV")
    private BigDecimal periodicMonthlyActiveUserGmv;
    @ExcelProperty("周期拉新会员数")
    private Long periodicNewMemberCount;
    @ExcelProperty("周期拉新会员GMV")
    private BigDecimal periodicNewMemberGmv;
    @ExcelProperty("次月月活会员数")
    private Long nextMonthActiveMemberCount;
    @ExcelProperty("次月月活会员GMV")
    private BigDecimal nextMonthActiveMemberGmv;
    @ExcelProperty("次月拉新会员数")
    private Long nextMonthNewMemberCount;
    @ExcelProperty("次月拉新会员GMV")
    private BigDecimal nextMonthNewMemberGmv;
    @ExcelProperty("活动类型")
    private String activityType;

    @ExcelProperty("活动花费差值")
    private BigDecimal costDiff;

    @ExcelProperty("监控比率差值")
    private BigDecimal monitorRateDiff;

    @ExcelProperty("曝光次数差值")
    private Long exposureCountDiff;

    @ExcelProperty("曝光人数差值")
    private Long exposureUserCountDiff;

    @ExcelProperty("点击次数差值")
    private Long clickCountDiff;

    @ExcelProperty("点击人数差值")
    private Long clickUserCountDiff;

    @ExcelProperty("月活会员数差值")
    private Long monthlyActiveMemberCountDiff;

    @ExcelProperty("月活会员GMV差值")
    private BigDecimal monthlyActiveMemberGmvDiff;

    @ExcelProperty("拉新会员数差值")
    private Long newMemberAcquisitionCountDiff;

    @ExcelProperty("拉新会员GMV差值")
    private BigDecimal newMemberAcquisitionGmvDiff;

    @ExcelProperty("周期月活人数差值")
    private Long periodicMonthlyActiveUserCountDiff;

    @ExcelProperty("周期月活GMV差值")
    private BigDecimal periodicMonthlyActiveUserGmvDiff;

    @ExcelProperty("周期拉新会员数差值")
    private Long periodicNewMemberCountDiff;

    @ExcelProperty("周期拉新会员GMV差值")
    private BigDecimal periodicNewMemberGmvDiff;

    @ExcelProperty("次月月活会员数差值")
    private Long nextMonthActiveMemberCountDiff;

    @ExcelProperty("次月月活会员GMV差值")
    private BigDecimal nextMonthActiveMemberGmvDiff;

    @ExcelProperty("次月拉新会员数差值")
    private Long nextMonthNewMemberCountDiff;

    @ExcelProperty("次月拉新会员GMV差值")
    private BigDecimal nextMonthNewMemberGmvDiff;

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
