package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.hy.exceltemp.ContactTypeListExcel;
import com.hy.mapper.ActivityGroupMapper;
import com.hy.pojo.ActivityGroup;
import com.hy.service.ActivityGroupService;
import com.hy.utils.ExcelUtil;
import org.apache.xmlbeans.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

@Service
public class ActivityGroupServiceImpl implements ActivityGroupService {

    @Autowired
    private ActivityGroupMapper activityGroupMapper;

    @Override
    public List<ActivityGroup> findActivityGroup(String cname) {
        List<ActivityGroup> activityGroups = activityGroupMapper.selectActivityGroupByName(cname);

        return activityGroups;
    }

    @Override
    public void findActivityGroupDownload(HttpServletResponse response, String cname) throws IOException {
        String title = URLEncoder.encode("单活动归因-KOL投放表现-分活动"+ System.currentTimeMillis(),"UTF-8");
        List<ActivityGroup> activityGroups = findActivityGroup(cname);
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response, title);
        EasyExcel.write(response.getOutputStream(), ActivityGroup.class)
                .registerWriteHandler(strategy)
                .sheet("单活动归因-kol投放表现-分活动")
                .doWrite(activityGroups);
    }
}
