package com.example.WebProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.Customer;
import com.example.WebProject.repository.CartInfoRepository;
@Service
public class CartInfoServiceIml 	implements CartInfoService {
		
		@Autowired
	    private CartInfoRepository cartInfoRepository;

		
		  @Override
		    public Iterable<CartInfo> findAll() {
		        return cartInfoRepository.findAll();
		    }

		   
		    @Override
		    public CartInfo findOne(int id) {
		        return cartInfoRepository.findOne(id);
		    }

		    @Override
		    public void save(CartInfo contact) {
		    	cartInfoRepository.save(contact);
		    }
		    
		    @Override
		    public void delete(int id) {
		    	cartInfoRepository.delete(id);
		    }
		    @Override
		    public List<CartInfo> findCartInfosByIdcustomer(Customer q) {
		        return cartInfoRepository.findCartInfosByIdcustomer(q);
		    }
	}