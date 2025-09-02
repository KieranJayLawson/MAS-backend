package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

public class ActivityGroup {
    @ExcelProperty("活动名称")
    private String campaignName;

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

    public BigDecimal getCpm() {
        return cpm;
    }

    public void setCpm(BigDecimal cpm) {
        this.cpm = cpm;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public BigDecimal getCac() {
        return cac;
    }

    public void setCac(BigDecimal cac) {
        this.cac = cac;
    }

    public BigDecimal getMamcRate() {
        return mamcRate;
    }

    public void setMamcRate(BigDecimal mamcRate) {
        this.mamcRate = mamcRate;
    }

    public BigDecimal getMamcGmvRate() {
        return mamcGmvRate;
    }

    public void setMamcGmvRate(BigDecimal mamcGmvRate) {
        this.mamcGmvRate = mamcGmvRate;
    }

    public BigDecimal getRnmRoi() {
        return rnmRoi;
    }

    public void setRnmRoi(BigDecimal rnmRoi) {
        this.rnmRoi = rnmRoi;
    }

    public BigDecimal getNmcRate() {
        return nmcRate;
    }

    public void setNmcRate(BigDecimal nmcRate) {
        this.nmcRate = nmcRate;
    }

    public BigDecimal getRnmCac() {
        return rnmCac;
    }

    public void setRnmCac(BigDecimal rnmCac) {
        this.rnmCac = rnmCac;
    }

    public BigDecimal getNmcGmvRate() {
        return nmcGmvRate;
    }

    public void setNmcGmvRate(BigDecimal nmcGmvRate) {
        this.nmcGmvRate = nmcGmvRate;
    }

    public BigDecimal getPcmaGmv() {
        return pcmaGmv;
    }

    public void setPcmaGmv(BigDecimal pcmaGmv) {
        this.pcmaGmv = pcmaGmv;
    }

    public BigDecimal getMpcmaGmv() {
        return mpcmaGmv;
    }

    public void setMpcmaGmv(BigDecimal mpcmaGmv) {
        this.mpcmaGmv = mpcmaGmv;
    }

    public BigDecimal getPanGmv() {
        return panGmv;
    }

    public void setPanGmv(BigDecimal panGmv) {
        this.panGmv = panGmv;
    }

    public BigDecimal getPcnGmv() {
        return pcnGmv;
    }

    public void setPcnGmv(BigDecimal pcnGmv) {
        this.pcnGmv = pcnGmv;
    }

    public BigDecimal getMasmrRate() {
        return masmrRate;
    }

    public void setMasmrRate(BigDecimal masmrRate) {
        this.masmrRate = masmrRate;
    }

    public BigDecimal getMrrrRate() {
        return mrrrRate;
    }

    public void setMrrrRate(BigDecimal mrrrRate) {
        this.mrrrRate = mrrrRate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Long getExposureCount() {
        return exposureCount;
    }

    public void setExposureCount(Long exposureCount) {
        this.exposureCount = exposureCount;
    }

    public Long getExposureUserCount() {
        return exposureUserCount;
    }

    public void setExposureUserCount(Long exposureUserCount) {
        this.exposureUserCount = exposureUserCount;
    }

    public BigDecimal getAvgImpressionFrequency() {
        return avgImpressionFrequency;
    }

    public void setAvgImpressionFrequency(BigDecimal avgImpressionFrequency) {
        this.avgImpressionFrequency = avgImpressionFrequency;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getClickUserCount() {
        return clickUserCount;
    }

    public void setClickUserCount(Long clickUserCount) {
        this.clickUserCount = clickUserCount;
    }

    public Long getMonthlyActiveMemberCount() {
        return monthlyActiveMemberCount;
    }

    public void setMonthlyActiveMemberCount(Long monthlyActiveMemberCount) {
        this.monthlyActiveMemberCount = monthlyActiveMemberCount;
    }

    public BigDecimal getMonthlyActiveMemberGmv() {
        return monthlyActiveMemberGmv;
    }

    public void setMonthlyActiveMemberGmv(BigDecimal monthlyActiveMemberGmv) {
        this.monthlyActiveMemberGmv = monthlyActiveMemberGmv;
    }

    public Long getNewMemberAcquisitionCount() {
        return newMemberAcquisitionCount;
    }

    public void setNewMemberAcquisitionCount(Long newMemberAcquisitionCount) {
        this.newMemberAcquisitionCount = newMemberAcquisitionCount;
    }

    public BigDecimal getNewMemberAcquisitionGmv() {
        return newMemberAcquisitionGmv;
    }

    public void setNewMemberAcquisitionGmv(BigDecimal newMemberAcquisitionGmv) {
        this.newMemberAcquisitionGmv = newMemberAcquisitionGmv;
    }

    public Long getNextMonthActiveMemberCount() {
        return nextMonthActiveMemberCount;
    }

    public void setNextMonthActiveMemberCount(Long nextMonthActiveMemberCount) {
        this.nextMonthActiveMemberCount = nextMonthActiveMemberCount;
    }

    public BigDecimal getNextMonthActiveMemberGmv() {
        return nextMonthActiveMemberGmv;
    }

    public void setNextMonthActiveMemberGmv(BigDecimal nextMonthActiveMemberGmv) {
        this.nextMonthActiveMemberGmv = nextMonthActiveMemberGmv;
    }

    public Long getNextMonthNewMemberCount() {
        return nextMonthNewMemberCount;
    }

    public void setNextMonthNewMemberCount(Long nextMonthNewMemberCount) {
        this.nextMonthNewMemberCount = nextMonthNewMemberCount;
    }

    public BigDecimal getNextMonthNewMemberGmv() {
        return nextMonthNewMemberGmv;
    }

    public void setNextMonthNewMemberGmv(BigDecimal nextMonthNewMemberGmv) {
        this.nextMonthNewMemberGmv = nextMonthNewMemberGmv;
    }
}