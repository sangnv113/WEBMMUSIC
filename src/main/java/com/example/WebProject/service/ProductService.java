
package com.example.WebProject.service;
import java.util.List;

import com.example.WebProject.entity.Products;


public interface ProductService {

	Iterable<Products> findAll();

    List<Products> search(String q);

    Products findOne(int id);

    void save(Products contact);

    void delete(int id);
     int count();
    List<Products> findProductBycategory(int cid);
     
}
