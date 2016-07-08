package cc.hdp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.hdp.dao.UserDao;
import cc.hdp.entity.User;
import cc.hdp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> findAll() {
		List<User> findAll = userDao.findAll();
		return findAll;
	}
}
