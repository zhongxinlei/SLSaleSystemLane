package org.slsale.dao.user;

import org.slsale.pojo.user.User;

public interface UserMapper {
	
	
	/**
	 * login
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user) throws Exception;
	
	/**
	 * registration
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception;

}
