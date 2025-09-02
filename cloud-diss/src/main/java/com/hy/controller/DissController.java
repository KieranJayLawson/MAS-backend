package com.hy.controller;

import com.hy.mapper.TbDistributorMapper;
import com.hy.pojo.TbDistributor;
import com.hy.service.DissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diss")
public class DissController {

    @Autowired
    private DissService dissService;

    //根据远程传递的ID查询当前ID用户管理的分销商信息
    @GetMapping("/findDissByUidLJ")
    public List<TbDistributor> findDissByUid(@RequestParam Integer uid){
        return dissService.findDissByUid(uid);
    }
}
