package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * program: seckill->SuccessKilled
 * description: 成功秒杀实体
 * author: gerry
 * created: 2020-03-01 13:36
 **/
@Data
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date creteTime;

    // 多对一的复合属性
    private Seckill seckill;

}
