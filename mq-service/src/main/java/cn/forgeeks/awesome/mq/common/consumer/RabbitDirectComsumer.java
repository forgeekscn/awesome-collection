package cn.forgeeks.awesome.mq.common.consumer;

import cn.forgeeks.awesome.common.dto.MessageDto;
import cn.forgeeks.awesome.mq.common.config.MqConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MqConsts.QUEUE_DIRECT_MSG)
public class RabbitDirectComsumer {
    public static Logger log = LoggerFactory.getLogger(RabbitDirectComsumer.class);

    @RabbitHandler
    public void process(MessageDto message){
        log.info("直连Direct消费者:[{}]",message);
    }

}
