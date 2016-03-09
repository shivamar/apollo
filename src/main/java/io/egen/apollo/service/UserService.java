package io.egen.apollo.service;

import io.egen.apollo.entity.User;
import io.egen.apollo.exceptions.UserAlreadyExistsException;
import io.egen.apollo.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

	public List<User> findAllUsers ();
	public User findUserById(String id) throws UserNotFoundException;
	public User findUserByEmail(String email) throws UserNotFoundException;
	public User createUser(User user) throws UserAlreadyExistsException;
	public User updateUser(String id, User user) throws UserNotFoundException;
	public void deleteUser(String id) throws UserNotFoundException;
	
}
