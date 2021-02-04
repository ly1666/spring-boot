package com.liuyang.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author 刘阳
 * @date 2021/2/4 10:33 AM
 * @since
 * @version 
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GatewayApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(GatewayApp.class, args);
    }
}