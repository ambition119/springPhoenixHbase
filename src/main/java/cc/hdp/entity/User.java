package cc.hdp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	
	private String id;
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id+"\t"+userName+"\t"+password;
	}
}
