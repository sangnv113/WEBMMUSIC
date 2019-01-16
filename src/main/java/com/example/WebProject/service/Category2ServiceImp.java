
package com.example.WebProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.Category;
import com.example.WebProject.entity.Category2;
import com.example.WebProject.repository.Category2Repository;
import com.example.WebProject.repository.CategoryRepository;
@Service
public class Category2ServiceImp 	implements Category2Service {
		
		@Autowired
	    private Category2Repository categoryRepository;

		
		  @Override
		    public Iterable<Category2> findAll() {
		        return categoryRepository.findAll();
		    }

		    @Override
		    public List<Category2> search(String q) {
		        return categoryRepository.findByCategoryContaining(q);
		    }

		    @Override
		    public Category2 findOne(int id) {
		        return categoryRepository.findOne(id);
		    }

		    @Override
		    public void save(Category2 contact) {
		    	categoryRepository.save(contact);
		    }

		    @Override
		    public void delete(int id) {
		    	categoryRepository.delete(id);
		    	
		    }
		    @Override
		    public  List<Category2> findByCategoryContaining(String q){
		    	return categoryRepository.findByCategoryContaining(q);
		    }
		    @Override
		    public List<Category2> findByIdcpContaining(int q){
		    	return categoryRepository.findCategory2sByIdcp(q);
		    }
	}