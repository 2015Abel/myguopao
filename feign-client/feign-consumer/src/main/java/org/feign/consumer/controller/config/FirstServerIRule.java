package org.feign.consumer.controller.config;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class FirstServerIRule extends AbstractLoadBalancerRule {

	@Override
	public Server choose(Object arg0) {
		System.out.println(arg0);	//该参数为null，暂时不知道怎么传入此参数
		
		ILoadBalancer iLoadBalancer = getLoadBalancer();
		List<Server> canUserServers = iLoadBalancer.getReachableServers();
		if(CollectionUtils.isNotEmpty(canUserServers)){
			return canUserServers.get(0);
		}
		return null;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub

	}

}
