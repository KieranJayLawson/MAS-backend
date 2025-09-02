package com.hy.service;

import com.hy.pojo.ActivityPlatformInfluencergradeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityPlaInflugradeService {
    PageResult<ActivityPlatformInfluencergradeGroup> findInfluencergraderGroup(PageResultQuery query);

    void findInfluencergraderGroupDownload(HttpServletResponse response, PageResultQuery query) throws IOException;
}
