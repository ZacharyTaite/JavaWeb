package com.teamsun.service;

import com.teamsun.domain.User;
import com.teamsun.exception.UserExistException;
import com.teamsun.exception.UsersException;

public interface UserService {

	/**
	 * ����û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 * @param user
	 * @return
	 */
	public User login(User user) throws UsersException;
	
	/**
	 * �����û��������û��Ƿ����
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String name) throws UserExistException;
}
