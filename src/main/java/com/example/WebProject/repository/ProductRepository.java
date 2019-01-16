
package com.example.WebProject.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Products;


public interface ProductRepository extends CrudRepository<Products, Integer> {

	 List<Products> findByNameContaining(String q);
	 public List<Products> findProductssByCategory2id(int q);
	 long count();
	/* @Query("select prd from products prd where prd.cid2 = ?1")
	 List<Products> findProductssByCategory2id( int id);*/
}
