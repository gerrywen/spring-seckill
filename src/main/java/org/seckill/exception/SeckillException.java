package org.seckill.exception;

/**
 * program: seckill->SeckillException
 * description: 秒杀相关业务异常
 * author: gerry
 * created: 2020-03-01 14:55
 **/
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
