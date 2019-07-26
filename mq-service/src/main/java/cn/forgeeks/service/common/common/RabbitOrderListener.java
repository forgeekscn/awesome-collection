package cn.forgeeks.service.common.common;

import cn.forgeeks.service.common.dto.MessageDto;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 专门监听秒杀消费过程
 */
@Slf4j
@Component("rabbitOrderListener")
public class RabbitOrderListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws IOException {
        Long tag = message.getMessageProperties().getDeliveryTag();
        byte[] body = message.getBody();
        MessageDto msg = byteArrayToObject(body);
        log.info("消费者[{}]:接收到秒杀订单:[{}]", tag, msg);
        try {
            channel.basicAck(tag, true);
        } catch (Exception e) {
            channel.basicReject(tag, false);
            log.error("秒杀失败:[{}]", e);
        }

    }

    /**
     * Byte数组转对象
     */
    public MessageDto byteArrayToObject(byte[] bytes) {
        MessageDto obj = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = (MessageDto) objectInputStream.readObject();
        } catch (Exception e) {
            log.error("byteArrayToObject failed, " + e);
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    log.error("close byteArrayInputStream failed, " + e);
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    log.error("close objectInputStream failed, " + e);
                }
            }
        }
        return obj;
    }


}
