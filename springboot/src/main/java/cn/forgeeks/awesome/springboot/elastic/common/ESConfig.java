package cn.forgeeks.awesome.springboot.elastic.common;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * es配置类
 **/
@Configuration
public class ESConfig {

    @Value("${es.cluster.name}")
    private String clusterName;

    @Value("${es.cluster.ip}")
    private String clusterIp;

    @Value("${es.cluster.port}")
    private Integer clusterPort;


    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName(clusterIp),clusterPort);
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}