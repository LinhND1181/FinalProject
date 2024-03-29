package net.aht.internship.demo.domain.pagine;

import java.util.List;

public class PaginateDTO<T> {
    private List<T> pageData;
    private Integer currentPage;
    private Integer totalPage;

    public PaginateDTO() {
    }

    public PaginateDTO(List<T> pageData, Integer currentPage, Integer totalPage) {
        this.pageData = pageData;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
