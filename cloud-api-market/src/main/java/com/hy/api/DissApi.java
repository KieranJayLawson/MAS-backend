package com.hy.api;

import com.hy.pojo.TbDistributor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("cloud-diss-service")
public interface DissApi {

    @GetMapping("/diss/findDissByUidLJ")
    public List<TbDistributor> findDissByUid(@RequestParam Integer uid);
}
