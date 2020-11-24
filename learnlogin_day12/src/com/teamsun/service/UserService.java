package com.teamsun.service;

import com.teamsun.domain.User;
import com.teamsun.exception.UserExistException;
import com.teamsun.exception.UsersException;

public interface UserService {

	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 */
	public User login(User user) throws UsersException;
	
	/**
	 * 根据用户名查找用户是否存在
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String name) throws UserExistException;
}
