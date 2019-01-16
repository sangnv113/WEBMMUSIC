package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	 List<Category> findByCategoryContaining(String q);
	
}
