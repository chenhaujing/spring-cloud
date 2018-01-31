package com.chj.provider.repository;

import org.springframework.stereotype.Repository;

import com.chj.provider.entity.User;

@Repository
public class UserPepository {
	
	public User findOne(String id) {
		
		User user  = new User();
		if("1001".equals(id)) {
			user.setId("1001");
			user.setName("zhangsna");
			user.setAddress("beijing");
			user.setRemark("test user 1001 as search as db");
		}else {
			user.setId("1002");
			user.setName("lisi");
			user.setAddress("shanghai");
			user.setRemark("test user 1002 as search as db");
		}
		return user;
		
	}

}
