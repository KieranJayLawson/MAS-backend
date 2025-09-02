package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ContactTypeCompositionExcel;
import com.hy.exceltemp.ContactTypeListExcel;
import com.hy.exceltemp.PlatformDeliveryExcel;
import com.hy.mapper.ActivityMediaSlotAnalysisMapper;
import com.hy.pojo.MediaSlot;
import com.hy.pojo.PlatBean;
import com.hy.result.PageResult;
import com.hy.service.ActivityMediaSlotAnalysisService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActivityMediaSlotAnalysisServiceImpl implements ActivityMediaSlotAnalysisService {

    @Autowired
    private ActivityMediaSlotAnalysisMapper activityMediaSlotAnalysisMapper;


    @Override
    public List<String> findContactPoint() {
        return activityMediaSlotAnalysisMapper.findContactPoint();
    }

    @Override
    public PageResult<MediaSlot> findMediaSlot(String cid, String point, String orderField, String orderType, Integer pageNum,Integer pageSize,String media) {
        PageHelper.startPage(pageNum,pageSize);
        List<MediaSlot> mediaSlot = activityMediaSlotAnalysisMapper.findMediaSlot(cid, point, orderField, orderType,media);
        PageInfo<MediaSlot> info = new PageInfo<>(mediaSlot);
        return new PageResult<MediaSlot>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void mediaSlotDownload(HttpServletResponse response, String cid, String point, String orderField, String orderType,String media) throws IOException {
        List<MediaSlot> mediaSlotDLoad = activityMediaSlotAnalysisMapper.findMediaSlot(cid, point, orderField, orderType,media);
        String fileName = "MeiJieGuiYin"+System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), MediaSlot.class)
                .registerWriteHandler(strategy)
                .sheet("单活动归因-媒介归因排名")
                .doWrite(mediaSlotDLoad);
    }

    @Override
    public List<String> findAllMedia() {
        return activityMediaSlotAnalysisMapper.findAllMedia();
    }


    @Override
    public Map<String,Map<String, List<PlatBean>>> platformDeliveryComparison(String cidA, String cidB, String field) {
        HashMap<String, Map<String,List<PlatBean>>> map = new HashMap<>();
        List<PlatBean> pb=activityMediaSlotAnalysisMapper.platformDeliveryComparison(cidA,cidB,field);
        Map<String, List<PlatBean>> collect = pb.stream().collect(Collectors.groupingBy((x) -> x.getCname()));
        collect.forEach((k,v)->{
            Map<String, List<PlatBean>> collect1 = v.stream().collect(Collectors.groupingBy((y) -> y.getMedia()));
            map.put(k,collect1);
        });
        return map;

    }

    @Override
    public void platformDeliveryDownload(HttpServletResponse response, String cidA, String cidB, String field) throws IOException {
        List<PlatBean> pb=activityMediaSlotAnalysisMapper.platformDeliveryComparison(cidA,cidB,field);
        List<PlatformDeliveryExcel> collect = pb.stream().map((x) -> {
            PlatformDeliveryExcel p = new PlatformDeliveryExcel();
            BeanUtils.copyProperties(x, p);
            return p;
        }).collect(Collectors.toList());

        String fileName = URLEncoder.encode("多活动归因-分媒介投放对比-分媒介平台构成"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), PlatformDeliveryExcel.class)
                .registerWriteHandler(strategy)
                .sheet("多活动归因-分媒介投放对比-分媒介平台构成")
                .doWrite(collect);
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> contactTypeComposition(String cidA, String cidB, String field) {
        HashMap<String, Map<String,List<PlatBean>>> map = new HashMap<>();
        List<PlatBean> pb = activityMediaSlotAnalysisMapper.contactTypeComposition(cidA,cidB,field);
        Map<String, List<PlatBean>> collect = pb.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));
        collect.forEach((k,v)->{
            Map<String, List<PlatBean>> collect1 = v.stream().collect(Collectors.groupingBy((y) -> y.getCname()));
            map.put(k,collect1);
        });
        return map;
    }

    @Override
    public void contactTypeCompositionDownload(HttpServletResponse response, String cidA, String cidB, String field) throws IOException {
        List<PlatBean> pb = activityMediaSlotAnalysisMapper.contactTypeComposition(cidA,cidB,field);
        List<ContactTypeCompositionExcel> collect = pb.stream().map((x) -> {
            ContactTypeCompositionExcel p = new ContactTypeCompositionExcel();
            BeanUtils.copyProperties(x, p);
            return p;
        }).collect(Collectors.toList());

        String fileName = URLEncoder.encode("多活动归因-分触点类型投放对比-分媒介分触点类型构成"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), ContactTypeCompositionExcel.class)
                .registerWriteHandler(strategy)
                .sheet("多活动归因-分触点类型投放对比-分媒介分触点类型构成")
                .doWrite(collect);
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> contactTypeDistribution(String cidA, String cidB, String field,String media) {
        HashMap<String, Map<String,List<PlatBean>>> mm = new HashMap<>();
        List<PlatBean> list = activityMediaSlotAnalysisMapper.contactTypeDistribution(cidA,cidB,field,media);
        Map<String, List<PlatBean>> map = list.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));
        map.forEach((k,v)->{
            Map<String, List<PlatBean>> m = v.stream().collect(Collectors.groupingBy((y) -> y.getContactPoint()));
            m.forEach((j,n)->{
                Map<String, List<PlatBean>> collect = n.stream().collect(Collectors.groupingBy((z) -> z.getCname()));
                mm.put(k+"-"+j,collect);
            });
        });
        return mm;
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> mediaDistribution(String cidA, String cidB, String field) {
        HashMap<String, Map<String,List<PlatBean>>> map = new HashMap<>();
        List<PlatBean> pb = activityMediaSlotAnalysisMapper.mediaDistribution(cidA,cidB,field);
        Map<String, List<PlatBean>> collect = pb.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));
        collect.forEach((k,v)->{
            Map<String, List<PlatBean>> collect1 = v.stream().collect(Collectors.groupingBy((y) -> y.getCname()));
            map.put(k,collect1);
        });
        return map;
    }

    @Override
    public void mediaDistributionDownload(HttpServletResponse response, String cidA, String cidB, String field) throws IOException {
        List<PlatBean> pb=activityMediaSlotAnalysisMapper.mediaDistribution(cidA,cidB,field);
        List<PlatformDeliveryExcel> collect = pb.stream().map((x) -> {
            PlatformDeliveryExcel p = new PlatformDeliveryExcel();
            BeanUtils.copyProperties(x, p);
            return p;
        }).collect(Collectors.toList());

        String fileName = URLEncoder.encode("多活动归因-分媒介投放对比-分媒介平台分布"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), PlatformDeliveryExcel.class)
                .registerWriteHandler(strategy)
                .sheet("多活动归因-分媒介投放对比-分媒介平台分布")
                .doWrite(collect);
    }

    @Override
    public PageResult<ContactTypeListExcel> findcontactPointType(String cid, String point, String media, String orderField, String orderType, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ContactTypeListExcel> contactTypeListExcel = activityMediaSlotAnalysisMapper.findcontactPointType(cid, point, orderField, orderType,media);
        PageInfo<ContactTypeListExcel> info = new PageInfo<>(contactTypeListExcel);
        return new PageResult<ContactTypeListExcel>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void contactPointTypeDownload(HttpServletResponse response, String cid, String point, String media, String orderField, String orderType) throws IOException {
        List<ContactTypeListExcel> list = activityMediaSlotAnalysisMapper.findcontactPointType(cid, point, orderField, orderType,media);
        String fileName = "ChuDianGuiYin"+System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), ContactTypeListExcel.class)
                .registerWriteHandler(strategy)
                .sheet("单活动归因-触点类型归因排名")
                .doWrite(list);
    }

    @Override
    public void contactTypeDistributionDownload(HttpServletResponse response, String cidA, String cidB, String field, String media) throws IOException {
        List<PlatBean> pb = activityMediaSlotAnalysisMapper.contactTypeDistribution(cidA,cidB,field,media);
        List<ContactTypeCompositionExcel> collect = pb.stream().map((x) -> {
            ContactTypeCompositionExcel p = new ContactTypeCompositionExcel();
            BeanUtils.copyProperties(x, p);
            return p;
        }).collect(Collectors.toList());

        String fileName = URLEncoder.encode("多活动归因-分触点类型投放对比-分媒介分触点类型分布"+System.currentTimeMillis(),"utf-8");
        HorizontalCellStyleStrategy strategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(), ContactTypeCompositionExcel.class)
                .registerWriteHandler(strategy)
                .sheet("多活动归因-分触点类型投放对比-分媒介分触点类型分布")
                .doWrite(collect);
    }
}
