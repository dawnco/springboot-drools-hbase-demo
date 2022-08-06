package com.example.demo.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HBase相关配置
 *
 * @author zifangsky
 * @date 2018/7/12
 * @since 1.0.0
 */
@Configuration
public class HBaseConfig {
    @Value("${HBase.nodes}")
    private String nodes = "8.219.130.82";

    @Value("${HBase.maxsize}")
    private String maxsize = "500000";
    @Value("${HBase.port}")
    private String port = "8105";

    @Bean
    public HBaseService getHbaseService() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", nodes);
        conf.set("hbase.client.keyvalue.maxsize", maxsize);
        conf.set("hbase.zookeeper.property.clientPort", port);
        return new HBaseService(conf);
    }
}