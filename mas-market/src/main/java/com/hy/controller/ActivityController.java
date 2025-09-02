package com.hy.controller;

import com.hy.exceltemp.ContactTypeListExcel;
import com.hy.pojo.*;
import com.hy.result.ContentResult;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.result.Result;
import com.hy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
//@RefreshScope
@RequestMapping("/market")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMediaSlotAnalysisService activityMediaSlotAnalysisService;
    @Autowired
    private ActivityGroupService activityGroupService;
    @Autowired
    private ActivityPlatformGroupService activityPlatformGroupService;
    @Autowired
    private ActivityPlatformContentGroupService activityPlatformContentGroupService;
    @Autowired
    private ActivityConDirectionGroupService activityConDirectionGroupService;
    @Autowired
    private ActivityPlaInflugradeService  activityPlaInflugradeService;
    @Autowired
    private ActivityPlaInfluencertypeGroupService activityPlaInfluencertypeGroupService;
    @Autowired
    private ActivityKolGroupService activityKolGroupService;

    @Value("${upload}")
    private String upload;

    //单活动归因-查询最新活动列表
    @GetMapping("/findNewAnListLJ")
    public Result findNewAnListLJ(){
        List<ActivityAnalysis>  activityAnalysisList = activityService.findNewAnList();
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,activityAnalysisList);
    }

    //单活动归因-整体投放概览
    @GetMapping("/findNewAnLJ")
    public Result findNewAnLJ(String cid){
        ActivityAnalysis  activityAnalysis = activityService.findNewAnLJ(cid);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,activityAnalysis);
    }

    //单活动归因-整体投放概览-下载
    @GetMapping("/anDownloadLJ")
    public void download(HttpServletResponse response) {
        //访问service组装数据
        try {
            activityService.anDownload(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //单活动归因-转化效益分析
    @GetMapping("/getConversionIncomeLJ")
    public Result getConversionIncomeLJ(String cid,String status){//status = 1 曝光次数  2 曝光人数
        ConversionIncome conversionIncomes = activityService.getConversionIncome(cid,status);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,conversionIncomes);
    }
    //单活动归因-转化效益分析-下载
    @GetMapping("/getConversionIncomeDownloadLJ")
    public void getConversionIncomeDownloadLJ(HttpServletResponse response,String cid,String status){
        try {
            activityService.conversionIncomeDownload(response,cid,status);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-媒介归因排名-查询触点类型集合
    @GetMapping("/findContactPointLJ")
    public Result findContactPointLJ() {
        List<String> contactPointList = activityMediaSlotAnalysisService.findContactPoint();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MSG, contactPointList);
    }

    //单活动归因-媒介归因排名-媒介排名查询
    @GetMapping("/findMediaSlotLJ")
    public Result findMediaSlotLJ(String cid,String point,String orderField,String orderType,Integer pageNum,Integer pageSize,String media) {
        PageResult<MediaSlot> mediaSlotList = activityMediaSlotAnalysisService.findMediaSlot(cid,point,orderField,orderType,pageNum,pageSize,media);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MSG, mediaSlotList);
    }

    //单活动归因-媒介归因排名-下载
    @GetMapping("/findMediaSlotDownloadLJ")
    public void getMediaSlotDownloadLJ(HttpServletResponse response,String cid,String point,String orderField,String orderType,String media) {
        try {
            activityMediaSlotAnalysisService.mediaSlotDownload(response,cid,point,orderField,orderType,media);
        }   catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-触点类型归因排名-查询媒介平台集合
    @GetMapping("/findAllMediaLJ")
    public Result findAllMediaLJ() {
        List<String> mediaList = activityMediaSlotAnalysisService.findAllMedia();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MSG, mediaList);
    }

    //单活动归因-触点类型归因排名-触点类型排名
    @GetMapping("/findcontactPointTypeLJ")
    public Result findcontactPointTypeLJ(String cid,String point,String media,String orderField,String orderType,Integer pageNum,Integer pageSize){
        PageResult<ContactTypeListExcel> contactPointTypeList = activityMediaSlotAnalysisService.findcontactPointType(cid,point,media,orderField,orderType,pageNum,pageSize);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MSG, contactPointTypeList);
    }

    //单活动归因-触点类型归因排名-下载
    @GetMapping("/findcontactPointTypeDownloadLJ")
    public void findcontactPointTypeDownloadLJ(HttpServletResponse response,String cid,String point,String media,String orderField,String orderType){
        try {
            activityMediaSlotAnalysisService.contactPointTypeDownload(response,cid,point,media,orderField,orderType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分活动
    @GetMapping("/findActivityGroupLJ")
    public Result findActivityGroupLJ(String cname){
        List<ActivityGroup> activityGroup = activityGroupService.findActivityGroup(cname);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,activityGroup);
    }

    //单活动归因-kol投放表现-分活动-下载
    @GetMapping("/findActivityGroupDownloadLJ")
    public void findActivityGroupDownloadLJ(HttpServletResponse response,String cname){
        try {
            activityGroupService.findActivityGroupDownload(response,cname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分活动分媒介
    @PostMapping("/findActivityPlatformGroupLJ")
    public Result findActivityPlatformGroupLJ(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformGroup> list = activityPlatformGroupService.findActivityPlatformGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);
    }

    //单活动归因-kol投放表现-分活动分媒介-下载
    @PostMapping("/findActivityPlatformGroupDownloadLJ")
    public void findActivityPlatformGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query){
        try {
            activityPlatformGroupService.findActivityPlatformGroupDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分活动分内容形式
    @PostMapping("/findActivityPlatformContentGroupLJ")
    public Result findActivityPlatformContentGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformContentGroup> list = activityPlatformContentGroupService.findActivityPlatformContentGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);

    }

    //单活动归因-kol投放表现-分活动分内容形式-下载
    @PostMapping("/findActivityPlatformContentGroupDownloadLJ")
    public void findActivityPlatformContentGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        try {
            activityPlatformContentGroupService.findActivityPlatformContentGroupDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分媒介分活动分内容方向
    @PostMapping("/findActivityConDirectionGroupLJ")
    public Result findActivityConDirectionGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformContentDirectionGroup> list = activityConDirectionGroupService.findActivityConDirectionGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);
    }

    //单活动归因-kol投放表现-分媒介分活动分内容方向-下载
    @PostMapping("/findActivityDirectionGroupDownloadLJ")
    public void findActivityDirectionGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
       try{
           activityConDirectionGroupService.findActivityConDirectionGDownload(response,query);
    } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    //单活动归因-kol投放表现-分媒介分活动分达人等级
    @PostMapping("/findInfluencergraderGroupLJ")
    public Result findInfluencergraderGroup(@RequestBody PageResultQuery query)
    {
        PageResult<ActivityPlatformInfluencergradeGroup> list = activityPlaInflugradeService.findInfluencergraderGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);
    }

    //单活动归因-kol投放表现-分媒介分活动分达人等级-下载
    @PostMapping("/findInfluencergraderGroupDownloadLJ")
    public void findInfluencergraderGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        try{
            activityPlaInflugradeService.findInfluencergraderGroupDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分活动分媒介分达人类型
    @PostMapping("/findInfluencertypeGroupLJ")
    public Result findInfluencertypeGroup(@RequestBody PageResultQuery query) {
        PageResult<ActivityPlatformInfluencertypeGroup> list = activityPlaInfluencertypeGroupService.findInfluencertypeGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);
    }

    //单活动归因-kol投放表现-分活动分媒介分达人类型-下载
    @PostMapping("/findInfluencertypeGroupDownloadLJ")
    public void findInfluencertypeGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        try{
            activityPlaInfluencertypeGroupService.findInfluencertypeGroupDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-分活动分帖子
    @PostMapping("/findActivityKolGroupLJ")
    public Result findActivityKolGroup(@RequestBody PageResultQuery query) {
        PageResult<ActivityKolGroup> list = activityKolGroupService.findActivityKolGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,list);
    }

    //单活动归因-kol投放表现-分活动分帖子-下载
    @PostMapping("/findActivityKolGroupDownloadLJ")
    public void findActivityKolGroupDownloadLJ(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        try{
            activityKolGroupService.findActivityKolGroupDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //单活动归因-kol投放表现-kol统一下载
    @PostMapping("/kolDownloadLJ")
    public void kolDownload(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        try{ activityKolGroupService.kolDownload(response,query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //多活动归因-获取活动类型
    @GetMapping("/findTypeAndCnamesLJ")
    public Result findTypeAndCnames(){
        Map<String,List<String>> map =activityService.findTypeAndCnames();
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,map);
    }

    //多活动归因-核心指标对比
    @GetMapping("/ComparisionOfCoreIndicatorsLJ")
    public Result comparisionOfCoreIndicatorsLJ(String cidA,String cidB){
        ActivityAlogAndDiff as =activityService.comparisionOfCoreIndicators(cidA,cidB);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,as);
    }

    //多活动归因-核心指标对比-下载
    @GetMapping("/ComparisionOfCoreIndicatorsDownloadLJ")
    public void ComparisionOfCoreIndicatorsDownloadLJ(HttpServletResponse response,String cidA,String cidB) throws IOException {
        try{ activityService.comparisionOfCoreIndicatorsDownload(response,cidA,cidB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //多活动归因-分媒介投放对比-分媒介平台构成
    @GetMapping("/platformDeliveryComparisonLJ")
    public Result platformDeliveryComparisonLJ(String cidA,String cidB,String field){
        Map<String,Map<String, List<PlatBean>>> as = activityMediaSlotAnalysisService.platformDeliveryComparison(cidA,cidB,field);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,as);
    }

    //多活动归因-分媒介投放对比-分媒介平台构成-下载
    @GetMapping("/platformDeliveryDownloadLJ")
    public void platformDeliveryDownloadLJ(HttpServletResponse response,String cidA,String cidB,String field) throws IOException {
        try{ activityMediaSlotAnalysisService.platformDeliveryDownload(response,cidA,cidB,field);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //多活动归因-分媒介投放对比-分媒介平台分布
    @GetMapping("/mediaDistributionLJ")
    public Result mediaDistribution(String cidA,String cidB,String field){
        Map<String,Map<String, List<PlatBean>>> as = activityMediaSlotAnalysisService.mediaDistribution(cidA,cidB,field);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,as);
    }

    //多活动归因-分媒介投放对比-分媒介平台分布-下载
    @GetMapping("/mediaDistributionDownloadLJ")
    public void mediaDistributionDownload(HttpServletResponse response,String cidA,String cidB,String field) throws IOException {
        try{ activityMediaSlotAnalysisService.mediaDistributionDownload(response,cidA,cidB,field);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //多活动归因-分触点类型投放对比-分媒介分触点类型构成
    @GetMapping("/contactTypeCompositionLJ")
    public Result contactTypeComposition(String cidA,String cidB,String field){
        Map<String,Map<String, List<PlatBean>>> as = activityMediaSlotAnalysisService.contactTypeComposition(cidA,cidB,field);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,as);
    }

    //多活动归因-分触点类型投放对比-分媒介分触点类型构成-下载
    @GetMapping("/contactTypeCompositionDownloadLJ")
    public void contactTypeCompositionDownload(HttpServletResponse response,String cidA,String cidB,String field) throws IOException {
        try{ activityMediaSlotAnalysisService.contactTypeCompositionDownload(response,cidA,cidB,field);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //多活动归因-分触点类型投放对比-分媒介分触点类型分布
    @GetMapping("/contactTypeDistributionLJ")
    public Result contactTypeDistribution(String cidA,String cidB,String field,String media){
        Map<String,Map<String, List<PlatBean>>> as = activityMediaSlotAnalysisService.contactTypeDistribution(cidA,cidB,field,media);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MSG,as);
    }

    //多活动归因-分触点类型投放对比-分媒介分触点类型分布-下载
    @GetMapping("/contactTypeDistributionDownloadLJ")
    public void contactTypeDistributionDownload(HttpServletResponse response,String cidA,String cidB,String field,String media) throws IOException {
        try{
            activityMediaSlotAnalysisService.contactTypeDistributionDownload(response,cidA,cidB,field,media);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //热更新
    @GetMapping("/uploadLJ")
    public String upload(){
        return upload;
    }
}

