package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.Category;
import com.example.WebProject.entity.Category2;

public interface Category2Service {

	Iterable<Category2> findAll();

 
	Category2 findOne(int id);

    void save(Category2 contact);

    void delete(int id);
    List<Category2> findByIdcpContaining(int q);
	List<Category2> search(String q);
	 List<Category2> findByCategoryContaining(String q);
}
