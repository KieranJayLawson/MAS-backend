package com.hy.service;

import com.hy.pojo.ActivityAnalysis;
import com.hy.pojo.ActivityAlogAndDiff;
import com.hy.pojo.ConversionIncome;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<ActivityAnalysis> findNewAnList();

    ActivityAnalysis findNewAnLJ(String cid);

    void anDownload(HttpServletResponse response) throws IOException;

    ConversionIncome getConversionIncome(String cid, String status);

    void conversionIncomeDownload(HttpServletResponse response, String cid, String status) throws IOException;

    Map<String, List<String>> findTypeAndCnames();

    ActivityAlogAndDiff comparisionOfCoreIndicators(String cidA, String cidB);

    void comparisionOfCoreIndicatorsDownload(HttpServletResponse response, String cidA, String cidB)throws IOException;

    List<ActivityAnalysis> findActivityCpm();
}
