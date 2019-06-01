package com.store.model.result;

public enum ResultType {
    Success(0,"操作成功"),
    Failed(1, "操作失败"),

    Authenticated(2, "已授权"),
    Unauthenticated(3, "未授权");

    private int CODE;
    private String MSG;

    ResultType(int CODE, String MSG) {
        this.CODE = CODE;
        this.MSG = MSG;
    }

    public int getCODE() {
        return CODE;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
}