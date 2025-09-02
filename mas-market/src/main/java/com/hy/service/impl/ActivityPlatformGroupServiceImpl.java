package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityPlatformGroupExcel;
import com.hy.mapper.ActivityPlatformGroupMapper;
import com.hy.pojo.ActivityPlatformGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlatformGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityPlatformGroupServiceImpl implements ActivityPlatformGroupService {
    @Autowired
    private ActivityPlatformGroupMapper activityPlatformGroupMapper;

    @Override
    public PageResult<ActivityPlatformGroup> findActivityPlatformGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformGroup> activityPlatformGroups = activityPlatformGroupMapper.findActivityPlatformGroup(query);
        PageInfo<ActivityPlatformGroup> info = new PageInfo<>(activityPlatformGroups);
        return  new PageResult<ActivityPlatformGroup>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findActivityPlatformGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityPlatformGroup> activityPlatformGroups = activityPlatformGroupMapper.findActivityPlatformGroup(query);
        String title = URLEncoder.encode("单活动归因-KOL投放表现-分活动分媒介"+System.currentTimeMillis(),"UTF-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response, title);

        List<ActivityPlatformGroupExcel> collect = activityPlatformGroups.stream().map((x) -> {
            ActivityPlatformGroupExcel y = new ActivityPlatformGroupExcel();
            BeanUtils.copyProperties(x,y);
            extracted(x, y);
            return y;
        }).collect(Collectors.toList());


        EasyExcel.write(response.getOutputStream(), ActivityPlatformGroupExcel.class)
                .sheet("单活动归因-kol投放表现-分活动分媒介")
                .registerWriteHandler(strategy)
                .doWrite(collect);
    }

    private static void extracted(ActivityPlatformGroup x, ActivityPlatformGroupExcel y) {
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
