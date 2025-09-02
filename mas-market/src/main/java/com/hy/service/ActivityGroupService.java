package com.hy.service;

import com.hy.pojo.ActivityGroup;
import com.hy.pojo.ActivityPlatformGroup;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ActivityGroupService {
    List<ActivityGroup> findActivityGroup(String cname);

    void findActivityGroupDownload(HttpServletResponse response, String cname)throws IOException;
}
