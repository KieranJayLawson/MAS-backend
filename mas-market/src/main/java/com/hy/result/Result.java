package com.hy.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
