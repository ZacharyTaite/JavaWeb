package com.teamsun.service.impl;

import org.omg.CORBA.UserException;

import com.teamsun.dao.UserDao;
import com.teamsun.dao.impl.UserDaoImpl;
import com.teamsun.domain.User;
import com.teamsun.exception.UserExistException;
import com.teamsun.exception.UsersException;
import com.teamsun.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	public void register(User user) throws Exception {
		userDao.addUser(user);
	}

	public User login(User user)  {
		User u = null;
		try {
			
			u = userDao.findUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			//写入日志
		}
		return u;
	}

	public boolean findUserByName(String name) throws UserExistException {
		 boolean b = userDao.findUserByName(name);
		 if(b){
			throw new UserExistException("用户名已存在"); 
		 }
		 return b;
	}

}
