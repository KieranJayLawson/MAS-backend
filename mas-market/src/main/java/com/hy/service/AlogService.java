package com.hy.service;

import com.hy.pojo.Alog;
import com.hy.pojo.AlogAvg;

/**
 * 指标计算
 */
public interface AlogService {

    public Alog getAlog(String cid);

    public AlogAvg getAlogAvg(String cid);
}
