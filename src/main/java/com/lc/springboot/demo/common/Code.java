package com.lc.springboot.demo.common;

public enum Code {
    SUCCESS(200), FAILED(400), ERROR(500);

    private Integer code;

    Code(int code) {
        this.code = code;
    }
}
