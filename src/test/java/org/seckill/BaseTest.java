package org.seckill;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * program: seckill->BaseTest
 * description: 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 * author: gerry
 * created: 2020-03-01 13:43
 **/
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BaseTest {
}
