package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConversionIncome {
    @ExcelProperty("花费")
    private BigDecimal cost;
    @ExcelProperty("曝光次数")
    private BigDecimal exposureCount;
    @ExcelProperty("曝光人数")
    private BigDecimal exposureUserCount;
    @ExcelProperty("活跃会员数")
    private BigDecimal monthlyActiveMemberCount;
    @ExcelProperty("拉新会员数")
    private BigDecimal newMemberAcquisitionCount;

    @ExcelProperty("曝光月活转化率")
    private BigDecimal emacRate;
    @ExcelProperty("曝光拉新转化率")
    private BigDecimal etnccRate;

    @ExcelProperty("历史均值-曝光月活转化率")
    private BigDecimal emacRateAvg;
    @ExcelProperty("历史均值-曝光拉新转化率")
    private BigDecimal etnccRateAvg;

    @ExcelProperty("曝光月活转化率-历史均值差值")
    private BigDecimal emacRateDiff;
    @ExcelProperty("曝光拉新转化率-历史均值差值")
    private BigDecimal etnccRateDiff;
}
