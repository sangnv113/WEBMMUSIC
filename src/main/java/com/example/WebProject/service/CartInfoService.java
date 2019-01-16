
package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.Customer;

public interface CartInfoService {

	Iterable<CartInfo> findAll();

 
	CartInfo findOne(int id);

    void save(CartInfo contact);

    void delete(int id);

	public List<CartInfo> findCartInfosByIdcustomer(Customer q);
	
}
