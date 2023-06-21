package com.azimao.heartbeat.common.entity;

public enum StatusEnum {

    SUCCESS("0", "执行成功"),

    BASE_ERROR("A0500", "应用执行出错"),

    REJECT_ERROR("A0505", "应用拒绝异常，请联系管理员！");

    private String code;
    private String msg;

    StatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
