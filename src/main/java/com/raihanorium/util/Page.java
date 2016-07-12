package com.raihanorium.util;

import java.util.List;

/**
 * Created by Raihan on 7/12/2016.
 */
public class Page {
    private long totalCount;
    private List resource;
    private Integer offset;
    private Integer pageSize;
    private SortDirection sortDirection;
    private String sortColumn;

    public Page() {
        this.offset = 0;
        this.pageSize = 10;
        this.sortDirection = SortDirection.ASC;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List getResource() {
        return resource;
    }

    public void setResource(List resource) {
        this.resource = resource;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", resource=" + resource +
                ", offset=" + offset +
                ", pageSize=" + pageSize +
                ", sortDirection=" + sortDirection +
                ", sortColumn='" + sortColumn + '\'' +
                '}';
    }
}

