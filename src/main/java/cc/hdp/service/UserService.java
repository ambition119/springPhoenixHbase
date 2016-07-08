package cc.hdp.service;

import java.util.List;

import cc.hdp.entity.User;

public interface UserService {
	public void addUser(User user);
	public List<User> findAll();
}
