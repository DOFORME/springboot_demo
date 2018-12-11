package com.lc.springboot.demo.common;

import lombok.Data;

@Data
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
}
