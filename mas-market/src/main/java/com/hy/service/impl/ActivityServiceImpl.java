package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.hy.exceltemp.ActivityAlogAndDiffExcel;
import com.hy.exceltemp.ActivityAnalysisExcel;
import com.hy.mapper.ActivityAnalysisMapper;
import com.hy.pojo.*;
import com.hy.service.ActivityService;
import com.hy.service.AlogService;
import com.hy.utils.AlogUtil;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityAnalysisMapper activityAnalysisMapper;

    @Autowired
    AlogService alogService;

    @Override
    public List<ActivityAnalysis> findNewAnList() {
        return activityAnalysisMapper.findNewAnList();
    }

    @Override
    public ActivityAnalysis findNewAnLJ(String cid) {
        //查询基本指标
        ActivityAnalysis ac = activityAnalysisMapper.selectAnByCid(cid);
        //查询公式计算指标
        Alog alog = alogService.getAlog(cid);
        //历史均值
        AlogAvg alogAvg = alogService.getAlogAvg(cid);
        //计算差值
        AlogDiff alogDiff = AlogUtil.alogDiff(alog,alogAvg);

        ac.setAlog(alog);
        ac.setAlogDiff(alogDiff);
        return ac;
    }

    @Override
    public void anDownload(HttpServletResponse response) throws IOException {
        List<ActivityAnalysis> act = activityAnalysisMapper.selectByExample(null);

        //文件名
        String fileName = "GuiYinGaiLan"+System.currentTimeMillis() + "";

        //调用工具类完成样式的调用
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        //拷贝数据
        List<ActivityAnalysisExcel> collect = act.stream().map((aet) -> {
            ActivityAnalysisExcel activityAnalysisExcel = new ActivityAnalysisExcel();
            BeanUtils.copyProperties(aet, activityAnalysisExcel);
            return activityAnalysisExcel;

        }).collect(Collectors.toList());


        //填充样式让其生效并且输出act的内容
        EasyExcel.write(response.getOutputStream(), ActivityAnalysisExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("单活动归因-整体投放概览")
                .doWrite(collect);
    }

    @Override
    public ConversionIncome getConversionIncome(String cid,String status) {
        List<ConversionIncome> conversionIncome = activityAnalysisMapper.getConversionIncome(cid);
        ConversionIncome conversionIncome1 = null;
        if(conversionIncome!=null&&conversionIncome.size()>0){
            conversionIncome1=conversionIncome.get(0);
        }

        BigDecimal emacRate = new BigDecimal(0);
        BigDecimal etnccRate = new BigDecimal(0);
        if(status.equals("1")){
            emacRate=conversionIncome1.getMonthlyActiveMemberCount()
                             .divide(conversionIncome1.getExposureCount(), 2 , RoundingMode.HALF_UP);
            etnccRate=conversionIncome1.getNewMemberAcquisitionCount()
                            .divide(conversionIncome1.getExposureCount(), 2 , RoundingMode.HALF_UP);
            conversionIncome1.setEmacRate(emacRate);
            conversionIncome1.setEtnccRate(etnccRate);

            ConversionIncome cec = activityAnalysisMapper.findAvgExposureCount();
            conversionIncome1.setEmacRateAvg(cec.getEmacRateAvg());
            conversionIncome1.setEtnccRateAvg(cec.getEtnccRateAvg());
            conversionIncome1.setEmacRateDiff(conversionIncome1.getEmacRate().subtract(conversionIncome1.getEmacRateAvg()));
            conversionIncome1.setEtnccRateDiff(conversionIncome1.getEtnccRate().subtract(conversionIncome1.getEtnccRateAvg()));//查询历史均值

        }else{
            emacRate=conversionIncome1.getMonthlyActiveMemberCount()
                    .divide(conversionIncome1.getExposureUserCount(), 2 , RoundingMode.HALF_UP);
            etnccRate=conversionIncome1.getNewMemberAcquisitionCount()
                    .divide(conversionIncome1.getExposureUserCount(), 2 , RoundingMode.HALF_UP);
            conversionIncome1.setEmacRate(emacRate);
            conversionIncome1.setEtnccRate(etnccRate);
            ConversionIncome cec = activityAnalysisMapper.findAvgExposureUserCount();
            conversionIncome1.setEmacRateAvg(cec.getEmacRateAvg());
            conversionIncome1.setEtnccRateAvg(cec.getEtnccRateAvg());
            conversionIncome1.setEmacRateDiff(conversionIncome1.getEmacRate().subtract(conversionIncome1.getEmacRateAvg()));
            conversionIncome1.setEtnccRateDiff(conversionIncome1.getEtnccRate().subtract(conversionIncome1.getEtnccRateAvg()));//查询历史均值

        }

        //设置计算指标

        return conversionIncome1;
    }

    @Override
    public void conversionIncomeDownload(HttpServletResponse response, String cid,String status) throws IOException {
        String fileName = "ZhuanHuaXiaoYiFenXi"+System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        ConversionIncome conversionIncome = getConversionIncome(cid, status);
        ArrayList<ConversionIncome> conversionIncomeList = new ArrayList<>();
        conversionIncomeList.add(conversionIncome);
        EasyExcel.write(response.getOutputStream(), ConversionIncome.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("单活动归因-转化效益分析")
                .doWrite(conversionIncomeList);
    }

    @Override
    public Map<String, List<String>> findTypeAndCnames() {
        List<ActivityAnalysis> list = activityAnalysisMapper.selectByExample(null);
        Map<String, List<ActivityAnalysis>> collect = list.stream().collect(Collectors.groupingBy((x) -> x.getActivityType()));
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        collect.forEach((k,v)->{
            List<String> l1 = v.stream().map((x)->{
                return x.getCampaignName();
            }).collect(Collectors.toList());
            stringListHashMap.put(k,l1);
        });
        return stringListHashMap;
    }

    @Override
    public ActivityAlogAndDiff comparisionOfCoreIndicators(String cidA, String cidB) {
        //组装数据
        //获取当前两个活动下的基本字段
        ActivityAnalysis anA = activityAnalysisMapper.selectAnByCid(cidA);
        ActivityAnalysis anB = activityAnalysisMapper.selectAnByCid(cidB);
        //获取当前两个活动下的计算指标
        Alog alogA = alogService.getAlog(cidA);
        Alog alogB = alogService.getAlog(cidB);

        anA.setAlog(alogA);
        anB.setAlog(alogB);

        //计算指标差值

        AlogDiff alogDiff = AlogUtil.alogDiffTwo(alogA, alogB);
        alogDiff.setCostDiff(anA.getCost().subtract(anB.getCost()));
        alogDiff.setMonitorRateDiff(anA.getMonitorRate().subtract(anB.getMonitorRate()));
        alogDiff.setExposureCountDiff(anA.getExposureCount()-anB.getExposureCount());
        alogDiff.setExposureUserCountDiff(anA.getExposureUserCount()-anB.getExposureUserCount());
        alogDiff.setClickCountDiff(anA.getClickCount()-anB.getClickCount());
        alogDiff.setClickUserCountDiff(anA.getClickUserCount()-anB.getClickUserCount());
        alogDiff.setMonthlyActiveMemberCountDiff(anA.getMonthlyActiveMemberCount()-anB.getMonthlyActiveMemberCount());
        alogDiff.setMonthlyActiveMemberGmvDiff(anA.getMonthlyActiveMemberGmv().subtract(anB.getMonthlyActiveMemberGmv()));
        alogDiff.setNewMemberAcquisitionCountDiff(anA.getNewMemberAcquisitionCount()-anB.getNewMemberAcquisitionCount());
        alogDiff.setNewMemberAcquisitionGmvDiff(anA.getNewMemberAcquisitionGmv().subtract(anB.getNewMemberAcquisitionGmv()));
        alogDiff.setPeriodicMonthlyActiveUserCountDiff(anA.getPeriodicMonthlyActiveUserCount()-anB.getPeriodicMonthlyActiveUserCount());
        alogDiff.setPeriodicMonthlyActiveUserGmvDiff(anA.getPeriodicMonthlyActiveUserGmv().subtract(anB.getPeriodicMonthlyActiveUserGmv()));
        alogDiff.setPeriodicNewMemberCountDiff(anA.getPeriodicNewMemberCount()-anB.getPeriodicNewMemberCount());
        alogDiff.setPeriodicNewMemberGmvDiff(anA.getPeriodicNewMemberGmv().subtract(anB.getPeriodicNewMemberGmv()));
        alogDiff.setNextMonthActiveMemberCountDiff(anA.getNextMonthActiveMemberCount()-anB.getNextMonthActiveMemberCount());
        alogDiff.setNextMonthActiveMemberGmvDiff(anA.getNextMonthActiveMemberGmv().subtract(anB.getNextMonthActiveMemberGmv()));
        alogDiff.setNextMonthNewMemberCountDiff(anA.getNextMonthNewMemberCount()-anB.getNextMonthNewMemberCount());
        alogDiff.setNextMonthNewMemberGmvDiff(anA.getNextMonthNewMemberGmv().subtract(anB.getNextMonthNewMemberGmv()));

        return new ActivityAlogAndDiff(anA,anB,alogDiff);
    }

    @Override
    public void comparisionOfCoreIndicatorsDownload(HttpServletResponse response, String cidA, String cidB) throws IOException {
        String fileName = URLEncoder.encode("多活动归因-核心指标对比"+System.currentTimeMillis() + "","utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        ActivityAlogAndDiff ad = comparisionOfCoreIndicators(cidA, cidB);
        ActivityAnalysis adA = ad.getActivityAnalysisA();
        ActivityAnalysis adB = ad.getActivityAnalysisB();
        AlogDiff adDiff = ad.getAlogDiff();

        ActivityAlogAndDiffExcel aeA = new ActivityAlogAndDiffExcel();
        BeanUtils.copyProperties(adA, aeA);
        BeanUtils.copyProperties(adDiff, aeA);

        ActivityAlogAndDiffExcel aeB = new ActivityAlogAndDiffExcel();
        BeanUtils.copyProperties(adB, aeB);
        BeanUtils.copyProperties(adDiff, aeB);

        ArrayList<ActivityAlogAndDiffExcel> list = new ArrayList<>();
        list.add(aeA);
        list.add(aeB);

        EasyExcel.write(response.getOutputStream(), ActivityAlogAndDiffExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("多活动归因-核心指标对比")
                .doWrite(list);

    }

    @Override
    public List<ActivityAnalysis> findActivityCpm() {
        return activityAnalysisMapper.findActivityCpm();
    }
}
