
package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, String> {

	 List<Customer> findByPhoneContaining(String q);

	 long count();
}
