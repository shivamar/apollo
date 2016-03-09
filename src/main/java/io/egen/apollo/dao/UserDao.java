package io.egen.apollo.dao;

import io.egen.apollo.entity.User;

import java.util.List;

public interface UserDao {
	public List<User> findAllUsers ();
	public User findUserById(String id);
	public User findUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
}
