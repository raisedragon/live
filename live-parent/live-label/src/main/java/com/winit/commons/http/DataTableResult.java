package com.winit.commons.http;

import java.util.List;

public class DataTableResult {

    private long         iTotalDisplayRecords;
    private List<? extends Object> aoData;
    private int          iTotalRecords;
    private String       sEcho;

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<? extends Object> getAoData() {
        return aoData;
    }

    public void setAoData(List<? extends Object> aoData) {
        this.aoData = aoData;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

}
