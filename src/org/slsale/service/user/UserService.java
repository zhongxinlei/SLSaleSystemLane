package org.slsale.service.user;

import org.slsale.pojo.user.User;

public interface UserService {
	
	public User getLoginUser(User user) throws Exception;
	
	public int addUser(User user) throws Exception;

}
