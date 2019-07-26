package cn.forgeeks.service.common.service;

import cn.forgeeks.awesome.kafka.common.KafkaSender;
import cn.forgeeks.service.common.common.RabbitLogSender;
import cn.forgeeks.service.common.common.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderService {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RabbitLogSender rabbitLogSender;

    @Autowired
    KafkaSender kafkaSender;

    public void test(){
        Object obj = redisUtil.get("k1");
        log.info("### redisUtil test [{}]",obj);
//        kafkaSender.send();
        log.info("### kafkaSender test [{}]",obj);

    }


}
