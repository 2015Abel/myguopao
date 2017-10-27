/**
 * 
 */
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName: BootStart
 * @Description: config-server启动类
 * @author: liuzijian
 * @date: 2017年10月26日 上午11:56:59
 */
@SpringBootApplication
@EnableConfigServer
public class ServerBootStart {

	public static void main(String[] args) {
		SpringApplication.run(ServerBootStart.class, args);
	}

}
