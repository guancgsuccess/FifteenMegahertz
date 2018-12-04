package com.fm.util.community;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页模型
 * YftPaper
 *
 * @param <E> E为操纵对象
 */
@Component
public class Page<E> {

    private Integer pageSize; //每页显示记录数
    private Integer totalRecord; //总记录数
    private Integer totalPages; //总页数
    private Integer currentPage; //当前页数
    private Integer offset; //从第几条开始
    private Integer limit; //到第几条结束
    private List<E> modelList; //当前页的对象集合

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<E> getModelList() {
        return modelList;
    }

    public void setModelList(List<E> modelList) {
        this.modelList = modelList;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Page{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", totalRecord=").append(totalRecord);
        sb.append(", totalPages=").append(totalPages);
        sb.append(", currentPage=").append(currentPage);
        sb.append(", offset=").append(offset);
        sb.append(", limit=").append(limit);
        sb.append(", modelList=").append(modelList);
        sb.append('}');
        return sb.toString();
    }
}
