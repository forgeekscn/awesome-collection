package cn.forgeeks.awesome.mq.common.consumer;

import cn.forgeeks.awesome.common.dto.MessageDto;
import cn.forgeeks.awesome.mq.common.config.MqConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MqConsts.QUEUE_FANOUT_A)
public class RabbitFanoutComsumerA {

    public static Logger log = LoggerFactory.getLogger(RabbitFanoutComsumerA.class);

    @RabbitHandler
    public void process(MessageDto messageDto){
        log.info("广播消费者消费A一条消息[{}]",messageDto);
    }

}
