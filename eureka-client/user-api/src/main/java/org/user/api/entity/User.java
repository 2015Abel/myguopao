/**
 * 
 */
package org.user.api.entity;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: 用户
 * @author: liuzijian
 * @date: 2017年10月30日 下午5:53:20
 */
public class User implements Serializable{

	private static final long serialVersionUID = -8254590452828330844L;
	
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return String.format("用户信息：id=%d,name=%s",id,name);
	}
	
}
