package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

//import java.util.Optional;

import com.example.demo.persistence.domain.Account;
import com.example.demo.persistence.repo.AccountRepo;
@Service
public class AccountService {
    public AccountRepo repo;
    public AccountService(AccountRepo repo) {
    	super();
    	this.repo = repo;
    }
	public Account createAccount(Account acc) {
		return this.repo.saveAndFlush(acc);
	}
	public List<Account> readAll() {
		return this.repo.findAll();
	}
	public Account findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	public Account updateAccount(Long id, Account acc) {
		Account exists = this.repo.getById(id);
		//System.out.println(exists);
		exists.setName(acc.getName());
		Account updated = this.repo.save(exists);
	    return updated;
	}
	
	public Boolean deleteAccount(Long id) {
		this.repo.deleteById(id);
	    return this.repo.existsById(id);
	}
	
	
	public List<Account> findByName(String name) {
		return this.repo.findByName(name);
	}

}
