/**
 * 
 */
package com.demo;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName: ClientBootStart
 * @Description: config-client启动类
 * @author: liuzijian
 * @date: 2017年10月26日 下午5:10:00
 */
@SpringBootApplication
public class ClientBootStart {
	
	ContextRefresher contextRefresher;
	Environment env;
	
	ClientBootStart(ContextRefresher contextRefresher,Environment env){
		this.contextRefresher = contextRefresher;
		this.env = env;
	}
	
	@Scheduled(fixedRate = 5*1000)
	public void refreshProperties(){
//		System.out.println("<<<<<<<< currentTime="+new SimpleDateFormat("HH:mm:ss").format(new Date()));
		Set<String> updatedProperties = contextRefresher.refresh();
		for(String property:updatedProperties){
			System.out.println(
					String.format("Thread-%s property属性刷新，key=%s val=%s", 
							Thread.currentThread().getName(),
							property,
							env.getProperty(property)));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientBootStart.class, args);
	}

}
