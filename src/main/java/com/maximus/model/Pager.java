package com.maximus.model;

import java.util.List;

/**
 * Created by gongchengdong on 15-3-2.
 */
public class Pager<T> {

    public static final int DEFAULT_PAGE_SIZE = 20;

    private long skip;
    private int pageNumber;
    private int pageSize;
    private long recordCount;
    private long pageCount;
    private List<T> results;

    /**
     * 指定当前起始记录下标和每页记录数，初始化Pager
     * @param skip
     * @param pageSize
     */
    public Pager(long skip, int pageSize) {
        this.skip = skip < 0 ? 0 : skip;
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        // TODO
        this.pageNumber = 0;
    }

    /**
     * 指定当前页码和每页记录数，初始化Pager
     * @param pageNumber
     * @param pageSize
     */
    public Pager(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        this.skip = this.pageSize * (this.pageNumber - 1);
    }

    public Pager(Integer pageNumber, Integer pageSize) {
        this(pageNumber==null?1:pageNumber,pageSize==null?0:pageSize);
    }

    public long getSkip() {
        return skip;
    }

    public void setSkip(long skip) {
        this.skip = skip;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getPageCount() {
        if (pageCount <= 0) {
            pageCount = (int) Math.ceil((double) recordCount / pageSize);
        }
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return String.format("size: %d, total: %d, page: %d/%d, skip: %d",
                pageSize,
                recordCount,
                pageNumber,
                this.getPageCount(),skip);
    }

    public boolean isFirst() {
        return pageNumber == 1;
    }

    public boolean isLast() {
        if (pageCount == 0)
            return true;
        return pageNumber == pageCount;
    }

}
