package com.hy.service;

import com.hy.pojo.ActivityPlatformInfluencertypeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityPlaInfluencertypeGroupService {
    PageResult<ActivityPlatformInfluencertypeGroup> findInfluencertypeGroup(PageResultQuery query);

    void findInfluencertypeGroupDownload(HttpServletResponse response, PageResultQuery query)throws IOException;
}
