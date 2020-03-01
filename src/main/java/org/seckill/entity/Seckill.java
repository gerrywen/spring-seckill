package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * program: seckill->Seckill
 * description: 秒杀库存实体
 * author: gerry
 * created: 2020-03-01 13:35
 **/
@Data
public class Seckill {

    private long seckillId;

    private String name;

    private int number;

    private Date startTime;

    private Date endTime;

    private Date createTime;
}
