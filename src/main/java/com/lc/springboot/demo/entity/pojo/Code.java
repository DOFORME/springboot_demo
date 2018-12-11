package com.lc.springboot.demo.entity.pojo;

public enum Code {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 系统内部错误
     */
    FAILED(500, "server error");

    private Integer code;

    private String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
