package com.chenliang.entity;

public class ResponseObject {

    private String msg;
    // 0:fail   i:success
    private int state = 1;
    // data need to analysis
    private Object datas;

    private int page;
    private int size;
    private int count;

    public ResponseObject(String msg, int state, Object datas) {
        this.msg = msg;
        this.state = state;
        this.datas = datas;
    }

    public ResponseObject(int state, Object datas) {
        this.state = state;
        this.datas = datas;
    }

    public ResponseObject(String msg, int state) {
        this.msg = msg;
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
