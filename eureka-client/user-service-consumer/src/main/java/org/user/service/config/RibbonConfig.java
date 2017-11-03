/**
 * 
 */
package org.user.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @ClassName: RibbonConfig
 * @Description: ribbon自定义配置
 * @author: liuzijian
 * @date: 2017年11月3日 上午10:53:16
 */
@Configuration
public class RibbonConfig {
	
	@Bean
	public IRule ribbonRule(){
		return new RandomRule();	//改成随机规则
	}

}
