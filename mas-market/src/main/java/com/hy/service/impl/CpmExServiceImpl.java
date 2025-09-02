package com.hy.service.impl;

import com.hy.mapper.CpmExMapper;
import com.hy.pojo.CpmEx;
import com.hy.service.CpmExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpmExServiceImpl implements CpmExService {

    @Autowired
    private CpmExMapper cpmExMapper;

    @Override
    public void insertCpmEx(CpmEx ex) {
        cpmExMapper.insert(ex);
    }
}
