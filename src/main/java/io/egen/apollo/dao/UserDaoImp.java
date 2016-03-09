package io.egen.apollo.dao;

import io.egen.apollo.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> findAll= em.createNamedQuery("user.findAll", User.class);
    	List<User> users = findAll.getResultList();
    	return users;
	}

	@Override
	public User findUserById(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
    	query.setParameter("pEmail", email);
    	List<User> users = query.getResultList();
    	if(users != null && users.size() == 1) {
    		return users.get(0);
    	}
    	else {
    		return null;
    	}
	}

	@Override	
	public User createUser(User user) {
		//user =  findUserByEmail(user.getEmail());
		em.persist(user);
		return user;
	}

	@Override		
	public User updateUser(User user) {
		return em.merge(user);
	}

	@Override	
	public void deleteUser (User user) {
		user = em.find(User.class, user.getUser_id());
		em.remove(user);
	}	
}