
package com.example.WebProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.WebProjectApplication;
import com.example.WebProject.entity.Producer;
import com.example.WebProject.model.ProductInfo;
import com.example.WebProject.service.Category2Service;
import com.example.WebProject.service.ProducerService;
import com.example.WebProject.service.ProductService;
@Transactional
@Repository
public class ProductFilterDao {
	 @Autowired
	    private ProductService productService;
	  @Autowired
	    private Category2Service category2Service;
	 
		@Autowired
		
		private ProducerService producerService;
	
		
	//FILLTER
		//find with category
public List<ProductInfo> filterCategory(int category2, List<ProductInfo> listproduct) {
    	
        try {
        	List<ProductInfo> listproduct2=new ArrayList<ProductInfo>();
        	
        	for(int i=0; i<listproduct.size(); i++){
        		if(listproduct.get(i).getCategory2().equals(category2Service.findOne(category2).getCategory())){
        			listproduct2.add(listproduct.get(i));
        		}
        	}
            return listproduct2;
        	} catch (NoResultException e) {
            return null;
        }
    }
public List<ProductInfo> filterProducer(int producer, List<ProductInfo> listproduct) {
	
    try {
    	List<ProductInfo> listproduct2=new ArrayList<ProductInfo>();
    	
    	for(int i=0; i<listproduct.size(); i++){
    		if(listproduct.get(i).getProducer().equals(producerService.findOne(producer).getName())){
    			listproduct2.add(listproduct.get(i));
    		}
    	}
        return listproduct2;
    	} catch (NoResultException e) {
        return null;
    }
}

//fill <=5 producer
	public List<Producer> list5Producer(int cid) {
	
	  try {
        	List<Producer> listproducer=new ArrayList<Producer>();
        	List<Producer> producer=(List<Producer>) producerService.findByIdprContaining(cid);
       
        	
        	for(int i=0; i<5; i++){
        		if(i>=producer.size()){
        			 return listproducer;
        		 }
        		
        		listproducer.add(producer.get(i));
        		
        			}
            return listproducer;
        } catch (NoResultException e) {
            return null;
        }
    }
	
	public List<ProductInfo> filterPrice(int price1,int price2, List<ProductInfo> listproduct) {
		
	    try {
	    	List<ProductInfo> listproduct2=new ArrayList<ProductInfo>();
	    	int n;
	    	for(int i=0; i<listproduct.size(); i++){
	    		n=Integer.parseInt(productService.findOne(listproduct.get(i).getId()).getGiasaugiam());
	    		if(n>=price1&&n<=price2){
	    			listproduct2.add(listproduct.get(i));
	    		}
	    	}
	        return listproduct2;
	    	} catch (NoResultException e) {
	        return null;
	    }
	}
	public List<ProductInfo> filterPrice(int price1, List<ProductInfo> listproduct) {
		
	    try {
	    	List<ProductInfo> listproduct2=new ArrayList<ProductInfo>();
	    	int n;
	    	for(int i=0; i<listproduct.size(); i++){
	    		n=Integer.parseInt(productService.findOne(listproduct.get(i).getId()).getGiasaugiam());
	    		if(n>=price1){
	    			listproduct2.add(listproduct.get(i));
	    		}
	    	}
	        return listproduct2;
	    	} catch (NoResultException e) {
	        return null;
	    }
	}
	
}
