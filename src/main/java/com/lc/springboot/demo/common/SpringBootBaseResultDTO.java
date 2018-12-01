package com.lc.springboot.demo.common;

public class SpringBootBaseResultDTO {

    private Integer code;

    private String msg;

    private String data;

    public SpringBootBaseResultDTO() {
        this.code = 200;
        this.msg = "success";
        this.data = null;
    }

    public SpringBootBaseResultDTO(Integer code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
