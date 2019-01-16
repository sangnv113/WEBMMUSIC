
package com.example.WebProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.Customer;
import com.example.WebProject.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
	 
	
	  @Override
	    public Iterable<Customer> findAll() {
	        return customerRepository.findAll();
	    }

	    @Override
	    public List<Customer> search(String q) {
	        return customerRepository.findByPhoneContaining(q);
	    }

	    @Override
	    public Customer findOne(String id) {
	        return customerRepository.findOne(id);
	    }

	    @Override
	    public void save(Customer contact) {
	    	customerRepository.save(contact);
	    }

	    @Override
	    public void delete(String id) {
	    	customerRepository.delete(id);
	    }
	    
}
