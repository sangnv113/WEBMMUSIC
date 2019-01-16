package com.example.WebProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.CartLineInfo;
import com.example.WebProject.entity.CartLineInfoIndentity;
import com.example.WebProject.repository.CartLineInfoRepository;
@Service
public class CartLineInfoServiceImp 	implements CartLineInfoService {
		
		@Autowired
	    private CartLineInfoRepository cartLineInfoRepository;

		
		  @Override
		    public Iterable<CartLineInfo> findAll() {
		        return cartLineInfoRepository.findAll();
		    }

		  
		    @Override
		    public CartLineInfo findOne(CartLineInfoIndentity id) {
		        return cartLineInfoRepository.findOne(id);
		    }

		    @Override
		    public void save(CartLineInfo contact) {
		    	cartLineInfoRepository.save(contact);
		    }
		    
		    @Override
		    public void delete(CartLineInfoIndentity id) {
		    	cartLineInfoRepository.delete(id);
		    }
		   
		  
	}