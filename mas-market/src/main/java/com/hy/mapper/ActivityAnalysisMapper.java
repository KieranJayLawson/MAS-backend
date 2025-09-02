package com.hy.mapper;

import com.hy.pojo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivityAnalysisMapper {
    int countByExample(ActivityAnalysisExample example);

    int deleteByExample(ActivityAnalysisExample example);

    int insert(ActivityAnalysis record);

    int insertSelective(ActivityAnalysis record);

    List<ActivityAnalysis> selectByExample(ActivityAnalysisExample example);

    int updateByExampleSelective(@Param("record") ActivityAnalysis record, @Param("example") ActivityAnalysisExample example);

    int updateByExample(@Param("record") ActivityAnalysis record, @Param("example") ActivityAnalysisExample example);

    List<ActivityAnalysis> findNewAnList();

    Alog getAlog(@Param("cid") String cid);

    ActivityAnalysis selectAnByCid(@Param("cid") String cid);

    AlogAvg getAlogAvg(@Param("cid") String cid);

    List<ConversionIncome> getConversionIncome(@Param("cid") String cid);

    ConversionIncome findAvgExposureCount();

    ConversionIncome findAvgExposureUserCount();

    List<ActivityAnalysis> findActivityCpm();
}