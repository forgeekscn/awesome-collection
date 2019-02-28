package cn.forgeeks.awesome.springboot.elastic.common;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * es配置类
 **/
@Slf4j
@Configuration
public class ESConfig {

    @Value("${es.cluster.name}")
    private String clusterName;

    @Value("${es.cluster.ip}")
    private String clusterIp;

    @Value("${es.cluster.port}")
    private Integer clusterPort;


    @Bean
    public TransportClient client() throws Exception {
        // Settings settings = Settings.builder().put("cluster.name", clusterName).put("node.name", "wQGpxZ").build();
        Settings settings = Settings.builder().put("cluster.name", clusterName).put("node.name", "node-1").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(clusterIp), clusterPort));
        log.info("搜索引擎配置 es init config [{}]", settings);
        return client;
    }
}