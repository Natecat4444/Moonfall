package com.cognixia.jump.moonfall;

import java.util.List;

public interface DAOinterface {
	
	public List<User> getAllUsers();
	
	public boolean addUser(User u);
	
	public boolean deleteUser(User u);
	
	public boolean updateUser(User u);
	
}
