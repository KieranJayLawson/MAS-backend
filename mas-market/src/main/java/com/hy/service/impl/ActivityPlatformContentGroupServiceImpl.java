package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityPlaContentGroupExcel;
import com.hy.exceltemp.ActivityPlatformGroupExcel;
import com.hy.mapper.ActivityPlatformContentGroupMapper;
import com.hy.pojo.ActivityPlatformContentGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlatformContentGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityPlatformContentGroupServiceImpl implements ActivityPlatformContentGroupService {
    @Autowired
    private ActivityPlatformContentGroupMapper activityPlatformContentGroupMapper;

    @Override
    public PageResult<ActivityPlatformContentGroup> findActivityPlatformContentGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<ActivityPlatformContentGroup> list = activityPlatformContentGroupMapper.findActivityPlatformContentGroup(query);
        PageInfo<ActivityPlatformContentGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(), info.getTotal());
    }

    @Override
    public void findActivityPlatformContentGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityPlatformContentGroup> list = activityPlatformContentGroupMapper.findActivityPlatformContentGroup(query);
        String fileName = URLEncoder.encode("单活动归因-KOL投放表现-分活动分内容形式"+System.currentTimeMillis(), "UTF-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        List<ActivityPlaContentGroupExcel> collect = list.stream().map((x) -> {
            ActivityPlaContentGroupExcel y = new ActivityPlaContentGroupExcel();
            BeanUtils.copyProperties(x,y);
            extracted(x, y);
            return y;
        }).collect(Collectors.toList());


        EasyExcel.write(response.getOutputStream(), ActivityPlaContentGroupExcel.class)
                .sheet("单活动归因-kol投放表现-分活动分内容形式")
                .registerWriteHandler(strategy)
                .doWrite(collect);
    }

    private static void extracted(ActivityPlatformContentGroup x, ActivityPlaContentGroupExcel y) {
        y.setCpm(x.getAlog().getCpm());
        y.setRoi(x.getAlog().getRoi());
        y.setCac(x.getAlog().getCac());
        y.setMamcRate(x.getAlog().getMamcRate());
        y.setMamcGmvRate(x.getAlog().getMamcGmvRate());
        y.setRnmRoi(x.getAlog().getRnmRoi());
        y.setRnmCac(x.getAlog().getRnmCac());
        y.setNmcRate(x.getAlog().getNmcRate());
        y.setNmcGmvRate(x.getAlog().getNmcGmvRate());
        y.setPcmaGmv(x.getAlog().getPcmaGmv());
        y.setMpcmaGmv(x.getAlog().getMpcmaGmv());
        y.setPcnGmv(x.getAlog().getPcnGmv());
        y.setPanGmv(x.getAlog().getPanGmv());
        y.setMasmrRate(x.getAlog().getMasmrRate());
        y.setMrrrRate(x.getAlog().getMrrrRate());
    }
}
