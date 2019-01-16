package com.example.WebProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Account;



public interface AccountRepository extends CrudRepository<Account, String> {

	// List<Account> findByUserNameContaining(String q);
}
