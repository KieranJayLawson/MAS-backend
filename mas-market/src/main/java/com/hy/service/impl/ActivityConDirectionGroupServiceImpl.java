package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityConDirectionGroupExcel;
import com.hy.mapper.ActivityPlatformContentDirectionGroupMapper;
import com.hy.pojo.ActivityPlatformContentDirectionGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityConDirectionGroupService;
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
public class ActivityConDirectionGroupServiceImpl implements ActivityConDirectionGroupService {
    @Autowired
    private ActivityPlatformContentDirectionGroupMapper activityConDirectionGroupMapper;

    @Override
    public PageResult<ActivityPlatformContentDirectionGroup> findActivityConDirectionGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformContentDirectionGroup> list=activityConDirectionGroupMapper.findActivityConDirectionGroup(query);
        PageInfo<ActivityPlatformContentDirectionGroup> info =new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findActivityConDirectionGDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityPlatformContentDirectionGroup> list=findActivityConDirectionGroup(query).getList();
        String fileName = URLEncoder.encode("单活动归因-KOL投放表现-分媒介分活动分内容方向"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);

        List<ActivityConDirectionGroupExcel> collect = list.stream().map((x) ->
        {
            ActivityConDirectionGroupExcel activityConDirectionGroupExcel = new ActivityConDirectionGroupExcel();
            BeanUtils.copyProperties(x, activityConDirectionGroupExcel);
            activityConDirectionGroupExcel.setCpm(x.getAlog().getCpm());
            activityConDirectionGroupExcel.setRoi(x.getAlog().getRoi());
            activityConDirectionGroupExcel.setCac(x.getAlog().getCac());
            activityConDirectionGroupExcel.setMamcRate(x.getAlog().getMamcRate());
            activityConDirectionGroupExcel.setMamcGmvRate(x.getAlog().getMamcGmvRate());
            activityConDirectionGroupExcel.setRnmRoi(x.getAlog().getRnmRoi());
            activityConDirectionGroupExcel.setRnmCac(x.getAlog().getRnmCac());
            activityConDirectionGroupExcel.setNmcRate(x.getAlog().getNmcRate());
            activityConDirectionGroupExcel.setNmcGmvRate(x.getAlog().getNmcGmvRate());
            activityConDirectionGroupExcel.setPcmaGmv(x.getAlog().getPcmaGmv());
            activityConDirectionGroupExcel.setMpcmaGmv(x.getAlog().getMpcmaGmv());
            activityConDirectionGroupExcel.setPcnGmv(x.getAlog().getPcnGmv());
            activityConDirectionGroupExcel.setPanGmv(x.getAlog().getPanGmv());
            activityConDirectionGroupExcel.setMasmrRate(x.getAlog().getMasmrRate());
            activityConDirectionGroupExcel.setMrrrRate(x.getAlog().getMrrrRate());
            return activityConDirectionGroupExcel;
        }).collect(Collectors.toList());

        EasyExcel.write(response.getOutputStream(), ActivityConDirectionGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("单活动归因-kol投放表现-分媒介分活动分内容方向")
                .doWrite(collect);
    }
}
