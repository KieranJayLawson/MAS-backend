package com.hy.controller;

import com.hy.api.DissApi;
import com.hy.pojo.TbDistributor;
import com.hy.pojo.TbUser;
import com.hy.result.ContentResult;
import com.hy.result.Result;
import com.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DissApi dissApi;
    @Autowired
    private UserService userService;
    //根据用户ID远程查询分销商信息
    @GetMapping("/selectDissByUidLJ")
    public Result selectDissByUid(Integer uid){
        TbUser user =userService.getUserByUid(uid);
        List<TbDistributor> dissByUid = dissApi.findDissByUid(uid);
        user.setDiss(dissByUid);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,user);
    }
}
