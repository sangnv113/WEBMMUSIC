package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.CartLineInfo;
import com.example.WebProject.entity.CartLineInfoIndentity;

public interface CartLineInfoService {

	Iterable<CartLineInfo> findAll();

 
	CartLineInfo findOne(CartLineInfoIndentity id);

    void save(CartLineInfo contact);

    void delete(CartLineInfoIndentity id);

	//List<CartLineInfo> search(String q);
	//List<CartLineInfo> findByNameContaining(String q);
}
