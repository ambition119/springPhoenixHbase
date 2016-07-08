package cc.hdp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cc.hdp.dao.UserDao;
import cc.hdp.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addUser(User user) {
		String sql = "UPSERT INTO USER(id,userName,password) VALUES(?,?,?)";
		Object[] params = new Object[]{user.getId(),user.getUserName(),user.getPassword()};
		//这里在service层中控制事务，所以dao没有commit
		jdbcTemplate.update(sql, params);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT id,userName,password FROM user";
		
		List<User> result = jdbcTemplate.query(sql, new RowMapper<User>() {  
		      @Override  
		      public User mapRow(ResultSet rs, int rowNum) throws SQLException{  
		          User user = new User();
		          user.setId(rs.getString("id"));
		          user.setUserName(rs.getString("userName"));
		          user.setPassword(rs.getString("password"));

		          return user;  

		  }});  
		return result;
	}

}
