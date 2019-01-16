

package com.example.WebProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.CommentRate;
import com.example.WebProject.entity.CommentRateIndentity;
import com.example.WebProject.repository.CommentRateRepository;

@Service
public class CommentRateServiceImp implements CommentRateService {
	
	@Autowired
    private CommentRateRepository commentRateRepository;
	 
	
	  @Override
	    public Iterable<CommentRate> findAll() {
	        return commentRateRepository.findAll();
	    }

	

	    @Override
	    public CommentRate findOne(CommentRateIndentity id) {
	        return commentRateRepository.findOne(id);
	    }

	    @Override
	    public void save(CommentRate contact) {
	    	commentRateRepository.save(contact);
	    }

	    @Override
	    public void delete(CommentRateIndentity id) {
	    	commentRateRepository.delete(id);
	    }
	    
}
