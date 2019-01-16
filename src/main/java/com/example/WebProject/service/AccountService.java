package com.example.WebProject.service;

import com.example.WebProject.entity.Account;


public interface AccountService {

	Iterable<Account> findAll();

 
	Account findOne(String userName);

    void save(Account contact);

    void delete(String userName);

	/*List<Color> search(String q);
	List<Color> findByNameContaining(String q);*/
}