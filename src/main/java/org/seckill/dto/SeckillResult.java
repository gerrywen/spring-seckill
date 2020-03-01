package org.seckill.dto;

import lombok.Data;

/**
 * program: seckill->SeckillResult
 * description: 封装json结果
 * author: gerry
 * created: 2020-03-01 14:57
 **/
@Data
public class SeckillResult<T> {
    private boolean success;

    private T data;

    private String error;


    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
