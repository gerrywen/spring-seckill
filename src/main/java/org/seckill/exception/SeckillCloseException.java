package org.seckill.exception;

/**
 * program: seckill->SeckillCloseException
 * description: 秒杀关闭异常
 * author: gerry
 * created: 2020-03-01 14:55
 **/
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
