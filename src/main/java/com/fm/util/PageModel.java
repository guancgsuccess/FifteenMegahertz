package com.fm.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用分页类
 */
@SuppressWarnings("all")
public class PageModel implements Serializable {
    private Integer pageSize;  //每页显示记录数
    private Integer totalRecord;  //总记录数
    private Integer totalPages;  //总页数
    private Integer currentPageCode;  //当前页码
    private Integer startRecord;  //从第几条记录开始查询
    private List<Map<String, Object>> modelList;  //分页封装的对象的集合

    public PageModel() {
    }

    public PageModel(Integer totalRecord, Integer totalPages, Integer currentPageCode, Integer startRecord, List<Map<String, Object>> modelList) {
        this.totalRecord = totalRecord;
        this.totalPages = totalPages;
        this.currentPageCode = currentPageCode;
        this.startRecord = startRecord;
        this.modelList = modelList;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPageCode() {
        return currentPageCode;
    }

    public void setCurrentPageCode(Integer currentPageCode) {
        this.currentPageCode = currentPageCode;
    }

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }

    public List<Map<String, Object>> getModelList() {
        return modelList;
    }

    public void setModelList(List<Map<String, Object>> modelList) {
        this.modelList = modelList;
    }
}
