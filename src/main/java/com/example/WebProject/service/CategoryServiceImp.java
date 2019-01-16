package com.example.WebProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.Category;
import com.example.WebProject.repository.CategoryRepository;
@Service
public class CategoryServiceImp 	implements CategoryService {
		
		@Autowired
	    private CategoryRepository categoryRepository;

		
		  @Override
		    public Iterable<Category> findAll() {
		        return categoryRepository.findAll();
		    }

		    @Override
		    public List<Category> search(String q) {
		        return categoryRepository.findByCategoryContaining(q);
		    }

		    @Override
		    public Category findOne(int id) {
		        return categoryRepository.findOne(id);
		    }

		    @Override
		    public void save(Category contact) {
		    	categoryRepository.save(contact);
		    }

		    @Override
		    public void delete(int id) {
		    	categoryRepository.delete(id);
		    	
		    }
		    @Override
		    public  List<Category> findByCategoryContaining(String q){
		    	return categoryRepository.findByCategoryContaining(q);
		    }
		  
	}