package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.mapper.ActivityPlatformInfluencertypeGroupMapper;
import com.hy.pojo.ActivityPlatformInfluencertypeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlaInfluencertypeGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ActivityPlaInfluencertypeGroupServiceImpl implements ActivityPlaInfluencertypeGroupService {
    @Autowired
    private ActivityPlatformInfluencertypeGroupMapper activityPlatformInfluencertypeGroupMapper;

    @Override
    public PageResult<ActivityPlatformInfluencertypeGroup> findInfluencertypeGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformInfluencertypeGroup> list = activityPlatformInfluencertypeGroupMapper.findInfluencertypeGroup(query);
        PageInfo<ActivityPlatformInfluencertypeGroup> info =new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findInfluencertypeGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityPlatformInfluencertypeGroup> list = activityPlatformInfluencertypeGroupMapper.findInfluencertypeGroup(query);
        String fileName = URLEncoder.encode("单活动归因-KOL投放表现-分活动分媒介分达人类型"+System.currentTimeMillis(),"UTF-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencertypeGroup.class)
                .registerWriteHandler(strategy)
                .sheet("单活动归因-kol投放表现-分活动分媒介分达人类型")
                .doWrite(list);

    }
}
