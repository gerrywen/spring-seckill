package org.seckill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SeckillServiceImplTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testLogs(){
        System.out.println("This is println message！");
        logger.error("error log");
        logger.debug("debug log");
        logger.info("info log");
    }

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        System.out.println(list);
        logger.debug("list={}", list);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        System.out.println(seckill);
        logger.info("seckill={}", seckill);
    }

    /**
     * 测试代码完整逻辑，注意可重复执行
     */
    @Test
    public void exportSeckillUrl() {
        long id = 1001;
        // 生成秒杀地址
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            System.out.println(exposer);
            logger.info("exposer={}", exposer);
            long phone = 13631231234L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                System.out.println(execution);
                logger.info("execution={}", execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            // 秒杀未开启
            logger.error("exposer={}", exposer);
        }
    }

    @Test
    public void executeSeckill() {
        long seckillId = 1001;
        long phone = 13631231234L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
            System.out.println(execution);
            logger.info(execution.getStateInfo());
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1001;
        long phone = 13631231234L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            System.out.println(execution);
            logger.info(execution.getStateInfo());
        }
    }
}