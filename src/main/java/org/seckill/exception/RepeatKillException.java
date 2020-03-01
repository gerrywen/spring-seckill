package org.seckill.exception;

/**
 * program: seckill->RepeatKillException
 * description: 重复秒杀异常（运行期异常）
 * author: gerry
 * created: 2020-03-01 14:56
 **/
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
