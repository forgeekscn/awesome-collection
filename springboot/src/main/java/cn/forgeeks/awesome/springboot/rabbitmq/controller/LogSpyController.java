package cn.forgeeks.awesome.springboot.rabbitmq.controller;

import cn.forgeeks.awesome.springboot.rabbitmq.common.*;
import cn.forgeeks.awesome.springboot.rabbitmq.dto.*;
import cn.forgeeks.awesome.springboot.rabbitmq.dto.MessageDto;
import cn.forgeeks.awesome.springboot.rabbitmq.dto.MessageSendDto;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  队列测试类
 */
@RestController
@Slf4j
@RequestMapping(value = "/rabbit")
public class LogSpyController {

    @Autowired
    RabbitLogSender rabbitSender;

    @Autowired
    RabbitMailSender rabbitMailSender;

    @Autowired
    RabbitOrderSender rabbitOrderSender;

    @Autowired
    RabbitDirectSender rabbitDirectSender;

    @Autowired
    RabbitFanoutSender rabbitFanoutSender;

    /**
     * 模拟生产特定类型消息并消费
     */
    @PostMapping(value = "/sendLogMsg")
    public ResultDto sendMsgWithCustomParams(@RequestBody MessageSendDto message){
        rabbitSender.sendWithCustomParams(message.getMessage(),message.getExchange() , message.getBindingKey());
        return new ResultDto(200,"Success.");
    }

    /**
     * 异步发送邮件
     */
    @RequestMapping(value = "/sendMail")
    public ResultDto sendMailAsyn(@RequestBody MessageSendDto mail){
        rabbitMailSender.sendMail(mail.getMessage());
        return new ResultDto(200,"Success.");
    }

    /**
     *  模拟秒杀场景消峰减压
     */
    @RequestMapping(value = "/createOrder" )
    public ResultDto createOrder(@RequestBody  MessageSendDto  param){
        rabbitOrderSender.sendOrderMsg( param.getMessage() ) ;
        return new ResultDto(200,"Success.");
    }
//
//    @Autowired
//    RabbitConfig rabbitConfig;
//    /**
//     *  模拟秒杀场景消峰减压
//     */
//    @RequestMapping(value = "/createOrderTemp" )
//    public ResultDto createOrderForNewMsg() throws IOException {
//        Connection conn  =  rabbitConfig.connectionFactory().createConnection();
//        Channel channel = conn.createChannel(true) ;
//        GetResponse response = channel.basicGet(Consts.QUEUE_MYTH_ORDER_ALL,true);
//        log.info("pull消息结果[{}]",new String(response.getBody()));
//        channel.basicAck(response.getEnvelope().getDeliveryTag(),false);
//        try {
//            channel.close();
//            conn.close();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
//        return new ResultDto(200,"Success.");
//    }


    /**
     *  测试Direct模式的消息分发
     */
    @RequestMapping(value = "/direct")
    public ResultDto directTest(@RequestBody MessageSendDto param){
        rabbitDirectSender.send(param.getMessage());
        return new ResultDto(200,"Success.");
    }

    /**
     *  测试广播模式消息分发
     */
    @RequestMapping(value = "/fanout")
    public ResultDto fanoutTest(@RequestBody MessageSendDto param){
        rabbitFanoutSender.send(param.getMessage());
        return new ResultDto(200,"Success.");
    }
}
