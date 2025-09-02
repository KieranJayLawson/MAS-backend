package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.mapper.ActivityKolGroupMapper;
import com.hy.pojo.ActivityKolGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.*;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ActivityKolGroupServiceImpl implements ActivityKolGroupService {
    @Autowired
    private ActivityKolGroupMapper activityKolGroupMapper;
    @Autowired
    private ActivityGroupService activityGroupService;
    @Autowired
    private ActivityPlatformGroupService activityPlatformGroupService;
    @Autowired
    private ActivityPlatformContentGroupService activityPlatformContentGroupService;
    @Autowired
    private ActivityConDirectionGroupService activityConDirectionGroupService;
    @Autowired
    private ActivityPlaInflugradeService  activityPlaInflugradeService;
    @Autowired
    private ActivityPlaInfluencertypeGroupService activityPlaInfluencertypeGroupService;


    @Override
    public PageResult<ActivityKolGroup> findActivityKolGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityKolGroup> list = activityKolGroupMapper.findActivityKolGroup(query);
        PageInfo<ActivityKolGroup> info =new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());

    }

    @Override
    public void kolDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        switch (query.getStatus()){
            case "1"://1 分活动-下载
                activityGroupService.findActivityGroupDownload(response,query.getCname());
                return;
            case "2"://2 分活动分媒介-下载
                activityPlatformGroupService.findActivityPlatformGroupDownload(response,query);
                return;
            case "3"://3 分活动分内容形式-下载
                activityPlatformContentGroupService.findActivityPlatformContentGroupDownload(response,query);
                return;
            case "4"://4 分媒介分活动分内容方向-下载
                activityConDirectionGroupService.findActivityConDirectionGDownload(response,query);
                return;
            case "5"://5 分媒介分活动分达人等级-下载
                activityPlaInflugradeService.findInfluencergraderGroupDownload(response,query);
                return;
            case "6"://6 分活动分媒介分达人类型-下载
                activityPlaInfluencertypeGroupService.findInfluencertypeGroupDownload(response,query);
                return;
            case "7"://7 分活动分帖子-下载
                findActivityKolGroupDownload(response,query);
        }
    }

    @Override
    public void findActivityKolGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityKolGroup> list = activityKolGroupMapper.findActivityKolGroup(query);
        String fileName = URLEncoder.encode("单活动归因-KOL投放表现-分活动分帖子"+System.currentTimeMillis(),"UTF-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        EasyExcel.write(response.getOutputStream(), ActivityKolGroup.class)
                .registerWriteHandler(strategy)
                .sheet("单活动归因-kol投放表现-分活动分帖子")
                .doWrite(list);
    }
}
