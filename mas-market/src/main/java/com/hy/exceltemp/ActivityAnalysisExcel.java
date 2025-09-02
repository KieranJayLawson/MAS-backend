package com.hy.exceltemp;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
@Data
public class ActivityAnalysisExcel {
    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("活动id")
    private String campaignId;

    @ExcelProperty("开始时间")
    private Date startDate;

    @ExcelProperty("结束时间")
    private Date endDate;

    @ExcelProperty("花费")
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

    @ExcelProperty("月活会员数GMV")
    private BigDecimal monthlyActiveMemberGmv;

    @ExcelProperty("拉新会员数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("拉新会员数GMV")
    private BigDecimal newMemberAcquisitionGmv;

    @ExcelProperty("周期月活人数")
    private Long periodicMonthlyActiveUserCount;

    @ExcelProperty("周期月活GMV")
    private BigDecimal periodicMonthlyActiveUserGmv;

    @ExcelProperty("周期新会员人数")
    private Long periodicNewMemberCount;

    @ExcelProperty("周期新会员GMV")
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

}