package com.hy.mapper;

import com.hy.exceltemp.ContactTypeListExcel;
import com.hy.pojo.ActivityMediaSlotAnalysis;
import com.hy.pojo.ActivityMediaSlotAnalysisExample;
import java.util.List;

import com.hy.pojo.MediaSlot;
import com.hy.pojo.PlatBean;
import org.apache.ibatis.annotations.Param;

public interface ActivityMediaSlotAnalysisMapper {
    int countByExample(ActivityMediaSlotAnalysisExample example);

    int deleteByExample(ActivityMediaSlotAnalysisExample example);

    int insert(ActivityMediaSlotAnalysis record);

    int insertSelective(ActivityMediaSlotAnalysis record);

    List<ActivityMediaSlotAnalysis> selectByExample(ActivityMediaSlotAnalysisExample example);

    int updateByExampleSelective(@Param("record") ActivityMediaSlotAnalysis record, @Param("example") ActivityMediaSlotAnalysisExample example);

    int updateByExample(@Param("record") ActivityMediaSlotAnalysis record, @Param("example") ActivityMediaSlotAnalysisExample example);

    List<String> findContactPoint();

    List<MediaSlot> findMediaSlot(@Param("cid") String cid,@Param("point")String point,@Param("orderField")String orderField, @Param("orderType") String orderType,@Param("media") String media);

    List<PlatBean> platformDeliveryComparison(@Param("cidA") String cidA, @Param("cidB") String cidB, @Param("field") String field);

    List<String> findAllMedia();

    List<PlatBean> contactTypeComposition(@Param("cidA") String cidA, @Param("cidB") String cidB, @Param("field") String field);

    List<PlatBean> contactTypeDistribution(@Param("cidA") String cidA, @Param("cidB") String cidB, @Param("field") String field,@Param("media") String media);

    List<PlatBean> mediaDistribution(@Param("cidA") String cidA, @Param("cidB") String cidB, @Param("field") String field);

    List<ContactTypeListExcel> findcontactPointType(@Param("cid") String cid, @Param("point") String point, @Param("orderField") String orderField, @Param("orderType") String orderType, @Param("media") String media);
}