package com.hy.result;

import lombok.Data;

import java.util.List;

@Data
public class PageResultQuery {
    private String status;//kol投放 顺序为文档里编写的
    private Integer pageNum;
    private Integer pageSize;
    private String cname;
    private List<String> medias;
    private List<String> content;
    private List<String> contentDirection;
    private List<String> talentLevel;
    private List<String> talentType;
    private List<String> kolName;
}
