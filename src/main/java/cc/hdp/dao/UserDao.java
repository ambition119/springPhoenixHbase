package cc.hdp.dao;

import java.util.List;

import cc.hdp.entity.User;

public interface UserDao {
	public void addUser(User user);
	public List<User> findAll();
}
