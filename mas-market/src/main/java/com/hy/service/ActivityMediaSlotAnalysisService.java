package com.hy.service;

import com.hy.exceltemp.ContactTypeListExcel;
import com.hy.pojo.MediaSlot;
import com.hy.pojo.PlatBean;
import com.hy.result.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ActivityMediaSlotAnalysisService {
    List<String> findContactPoint();

    PageResult<MediaSlot> findMediaSlot(String cid, String point, String orderField, String orderType, Integer pageNum, Integer pageSize,String media);

    void mediaSlotDownload(HttpServletResponse response, String cid, String point, String orderField, String orderType,String media) throws IOException;

    List<String> findAllMedia();

    Map<String,Map<String, List<PlatBean>>> platformDeliveryComparison(String cidA, String cidB, String field);

    void platformDeliveryDownload(HttpServletResponse response, String cidA, String cidB, String field) throws IOException;

    Map<String, Map<String, List<PlatBean>>> contactTypeComposition(String cidA, String cidB, String field);

    void contactTypeCompositionDownload(HttpServletResponse response, String cidA, String cidB, String field) throws  IOException;

    Map<String, Map<String, List<PlatBean>>> contactTypeDistribution(String cidA, String cidB, String field, String media);

    Map<String, Map<String, List<PlatBean>>> mediaDistribution(String cidA, String cidB, String field);

    void mediaDistributionDownload(HttpServletResponse response, String cidA, String cidB, String field) throws IOException;

    PageResult<ContactTypeListExcel> findcontactPointType(String cid, String point, String media, String orderField, String orderType, Integer pageNum, Integer pageSize);

    void contactPointTypeDownload(HttpServletResponse response, String cid, String point, String media, String orderField, String orderType) throws IOException;

    void contactTypeDistributionDownload(HttpServletResponse response, String cidA, String cidB, String field, String media)throws IOException;
}
