package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.Category;

public interface CategoryService {

	Iterable<Category> findAll();

 
	Category findOne(int id);

    void save(Category contact);

    void delete(int id);
	List<Category> search(String q);
	 List<Category> findByCategoryContaining(String q);
}
