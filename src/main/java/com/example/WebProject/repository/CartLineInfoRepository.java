package com.example.WebProject.repository;



import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.CartLineInfo;
import com.example.WebProject.entity.CartLineInfoIndentity;

public interface CartLineInfoRepository extends CrudRepository<CartLineInfo, CartLineInfoIndentity> {

	// List<CartLineInfo> findByNameContaining(String q);
}
