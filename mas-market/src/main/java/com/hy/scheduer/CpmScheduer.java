package com.hy.scheduer;

import com.hy.pojo.ActivityAnalysis;
import com.hy.pojo.CpmEx;
import com.hy.service.ActivityService;
import com.hy.service.CpmExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class CpmScheduer {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private CpmExService cpmExService;

    //编写定时器任务
    //@Scheduled(cron ="0 * * * * *" )
    public void taskCpm(){
        List<ActivityAnalysis> list = activityService.findActivityCpm();
        //判断cpm是否超出阈值
        list.stream().forEach((x)->{
            if(x.getCpm().intValue()>700){
                //不符合条件
                CpmEx ex = new CpmEx();
                ex.setCpm(x.getCpm().longValue());
                ex.setCid(Integer.parseInt(x.getCampaignId()));
                ex.setCpmDate(new Date());
                ex.setCpmDiff(x.getCpm().subtract(new BigDecimal(700)).longValue());
                ex.setCname(x.getCampaignName());
                ex.setStatus("0");
                cpmExService.insertCpmEx(ex);
            }
        });
    }

}

