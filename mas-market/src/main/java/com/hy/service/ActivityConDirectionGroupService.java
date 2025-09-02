package com.hy.service;

import com.hy.pojo.ActivityPlatformContentDirectionGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityConDirectionGroupService {
    PageResult<ActivityPlatformContentDirectionGroup> findActivityConDirectionGroup(PageResultQuery query);

    void findActivityConDirectionGDownload(HttpServletResponse response, PageResultQuery query) throws IOException;
}
