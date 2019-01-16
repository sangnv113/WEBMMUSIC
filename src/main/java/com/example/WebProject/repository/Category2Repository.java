
package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Category;
import com.example.WebProject.entity.Category2;
import com.example.WebProject.entity.Producer;

public interface Category2Repository extends CrudRepository<Category2, Integer> {

	 List<Category2> findByCategoryContaining(String q);
	
	 public List<Category2> findCategory2sByIdcp(int q);
}
