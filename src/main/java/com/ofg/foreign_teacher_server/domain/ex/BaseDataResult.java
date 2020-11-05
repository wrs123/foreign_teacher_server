package com.ofg.foreign_teacher_server.domain.ex;

import java.util.List;

public class BaseDataResult<T> {
    protected List<T> resultList = null;
    protected int totalNum = 0;
    protected int page = 0;
    protected int prePage = 0;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
}
