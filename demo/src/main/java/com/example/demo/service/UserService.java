package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.User;
import com.example.demo.persistence.repo.UserRepo;
@Service
public class UserService {
    public UserRepo repo;
    public UserService(UserRepo repo) {
    	super();
    	this.repo = repo;
    }
    
	public User createUser(User user) {
		return this.repo.saveAndFlush(user);
	}
	public List<User> readAll() {
		return this.repo.findAll();
	}
	public User findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	public User updateUser(Long id, User user) {
		User exists = this.repo.getById(id);
		//System.out.println(exists);
		exists.setUsername(user.getUsername());
		exists.setPassword(user.getPassword());
		exists.setFirstName(user.getFirstName());
		exists.setLastName(user.getLastName());
		exists.setDob(user.getDob());
		User updated = this.repo.save(exists);
	    return updated;
	}
	
	public Boolean deleteUser(Long id) {
		this.repo.deleteById(id);
	    return this.repo.existsById(id);
	}

}