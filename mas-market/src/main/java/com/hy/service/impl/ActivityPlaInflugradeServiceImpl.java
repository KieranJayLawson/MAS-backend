package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.mapper.ActivityPlatformInfluencergradeGroupMapper;
import com.hy.pojo.ActivityPlatformInfluencergradeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlaInflugradeService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ActivityPlaInflugradeServiceImpl implements ActivityPlaInflugradeService {
    @Autowired
    private ActivityPlatformInfluencergradeGroupMapper activityPlatformInfluencergradeGroupMapper;

    @Override
    public PageResult<ActivityPlatformInfluencergradeGroup> findInfluencergraderGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformInfluencergradeGroup> list = activityPlatformInfluencergradeGroupMapper.findInfluencergraderGroup(query);
        PageInfo<ActivityPlatformInfluencergradeGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findInfluencergraderGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityPlatformInfluencergradeGroup> influencergraderGroup = findInfluencergraderGroup(query);
        List<ActivityPlatformInfluencergradeGroup> list = influencergraderGroup.getList();

        String filename = URLEncoder.encode("单活动归因-KOL投放表现-分媒介分活动分达人等级"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, filename);
        EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencergradeGroup.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("单活动归因-kol投放表现-分媒介分活动分达人等级")
                .doWrite(list);
    }
}
