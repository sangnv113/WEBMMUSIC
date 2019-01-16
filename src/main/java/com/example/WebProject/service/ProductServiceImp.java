
package com.example.WebProject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.WebProject.entity.Category;
import com.example.WebProject.entity.Products;
import com.example.WebProject.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	 @PersistenceContext
	  private EntityManager em;
	
	  @Override
	    public Iterable<Products> findAll() {
	        return productRepository.findAll();
	    }

	    @Override
	    public List<Products> search(String q) {
	        return productRepository.findByNameContaining(q);
	    }

	    @Override
	    public Products findOne(int id) {
	        return productRepository.findOne(id);
	    }

	    @Override
	    public void save(Products contact) {
	    	productRepository.save(contact);
	    }

	    @Override
	    public void delete(int id) {
	    	productRepository.delete(id);
	    }
	    @Override
	    public int count() {
	    	
	    	
	    	return (int)productRepository.count();
	     
	    }
	    @Override
	    public List<Products> findProductBycategory(int cid){
	    	 return productRepository.findProductssByCategory2id(cid);
	    	
	    }
}
