package com.example.WebProject;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.WebProject.entity.CommentRate;
import com.example.WebProject.entity.Customer;
import com.example.WebProject.entity.Products;
import com.example.WebProject.service.CustomerService;
import com.example.WebProject.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebProjectApplicationTests {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@Transactional
	@Test
	public void contextLoads() {
		/*Products productA = new Products(100);
		Products productB = new Products(111);

		Customer customerA = new Customer("Customer A");
		Customer customerB = new Customer("Customer B");

		CommentRate commentRate = new CommentRate(customerB, productA, 1, "sfds");
		productA.getCommentrate().add(commentRate);

		CommentRate commentRate2 = new CommentRate(customerA, productB, 1, "sdffdsfd");
		customerA.getCommentrate().add(commentRate2);
		
		
		CommentRate commentRate3 = new CommentRate(customerA, productA, 1, "sdffdsfd");
		customerA.getCommentrate().add(commentRate3);
		
		CommentRate commentRate4 = new CommentRate(customerB, productB, 1, "sdffdsfd");
		customerA.getCommentrate().add(commentRate4);
		
		
		customerService.save(customerB);
		customerService.save(customerA);
		productService.save(productA);
		productService.save(productB);
		// test
		System.out.println(productA.getCommentrate().size());*/
	}
}
