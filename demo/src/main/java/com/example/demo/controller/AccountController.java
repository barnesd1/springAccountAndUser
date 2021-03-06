package com.example.demo.controller;
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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService service;
	
	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @PostMapping("/account/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account acc) {
        return new ResponseEntity<Account>(this.service.createAccount(acc),HttpStatus.CREATED);
    }
    
    @GetMapping("/account/getAll")
    public ResponseEntity<List<Account>> getAll() {
    	return new ResponseEntity<List<Account>>(this.service.readAll(), HttpStatus.OK);
    }
    
    @PutMapping("/account/update/{id}")
    ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody Account acc) {
    	return new ResponseEntity<Account>(this.service.updateAccount(id, acc), HttpStatus.OK);
    }
    
    @DeleteMapping("/account/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
    	return new ResponseEntity<Boolean>(this.service.deleteAccount(id), HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/account/findByName/{name}")
    public ResponseEntity<List<Account>> findByName(@PathVariable("name") String name) {
    	return new ResponseEntity<List<Account>>(this.service.findByName(name), HttpStatus.OK);
    }
}
