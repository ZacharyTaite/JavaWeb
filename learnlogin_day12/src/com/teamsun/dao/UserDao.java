package com.teamsun.dao;

import com.teamsun.domain.User;

public interface UserDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user)throws Exception;
	
	/**
	 * 根据用户名查找用户是否存在
	 * @param name
	 * @return
	 */
	public boolean findUserByName(String name);
}
