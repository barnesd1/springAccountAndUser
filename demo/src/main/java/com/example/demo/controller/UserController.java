package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	 //private List<User> userList = new ArrayList<>();
	 @Autowired
	 private UserService service;
	
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/user/testGetAll")
	public List<User> getAllUsers() {
		List<User> l = new ArrayList<>();
		long myId = 1001;
		User u = new User(myId, "bobby","p5ss", "Bob", "Martin", LocalDate.of(2000, Month.JANUARY, 8));
		l.add(u);
		return l;
    }
	
	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}
		
    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(this.service.createUser(user),HttpStatus.CREATED);
    }
    
    @GetMapping("/user/getAll")
    public ResponseEntity<List<User>> getAll() {
    	return new ResponseEntity<List<User>>(this.service.readAll(), HttpStatus.OK);
    }
    
    @PutMapping("/user/update/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    	return new ResponseEntity<User>(this.service.updateUser(id, user), HttpStatus.OK);
    }
    
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
    	return new ResponseEntity<Boolean>(this.service.deleteUser(id), HttpStatus.NO_CONTENT);
    }

}
