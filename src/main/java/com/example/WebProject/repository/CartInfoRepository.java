
package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.Customer;
import com.example.WebProject.entity.Products;

public interface CartInfoRepository extends CrudRepository<CartInfo, Integer> {

	public List<CartInfo> findCartInfosByIdcustomer(Customer q);
}
