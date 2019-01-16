
package com.example.WebProject.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.WebProject.WebProjectApplication;
import com.example.WebProject.dao.ProductDao;
import com.example.WebProject.dao.ProductFilterDao;
import com.example.WebProject.model.ProductFillter;
import com.example.WebProject.model.ProductInfo;
import com.example.WebProject.service.Category2Service;
import com.example.WebProject.service.ProducerService;


@Controller
public class FilterUkuleleController {
	@Autowired
	private ProductFilterDao productFilterDao;
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	
	private ProducerService producerService;
	
	@Autowired
	private Category2Service category2Service;
	

	private void AddAtribute(Model model){
		model.addAttribute("filter", new ProductFillter(-1, -1, -1, -1));
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterUkulele));
		model.addAttribute("categories", category2Service.findByIdcpContaining(WebProjectApplication.filterUkulele));
		model.addAttribute("prnumber", WebProjectApplication.productNumber);	
	}
	@GetMapping("/ukulelefilterCategory/{id}")
	public String adukuleleacousticCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE >LOẠI");
		return "/ukulele";
	}
	@GetMapping("/ukulelefilterProducer/{id}")
	public String adukuleleacousticProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE >HÃNG");
		return "/ukulele";
	}
	
	
	@GetMapping("/ukulelefilterPrice/{p1}")
	public String adukulele1pricer(Model model, @PathVariable int p1) {
		
		model.addAttribute("infos", ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE");
		return "/ukulele";
	}
	@GetMapping("/ukulelefilter")
	public String filter(Model model, @Valid ProductFillter filter) {
		String s="UKULELE";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterUkulele);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
			model.addAttribute("tittle", "UKULELE ");
			return "ukulele";
		}
		if(filter.getCategory2()>0){
			list=productFilterDao.filterCategory(filter.getCategory2(), list);
			if(category2Service.findOne(filter.getCategory2()).getCategory()!=null)
			s=s+" > "+category2Service.findOne(filter.getCategory2()).getCategory();
		}
		
		if(filter.getProducer()>0){
			list=productFilterDao.filterProducer(filter.getProducer(), list);
			if(producerService.findOne(filter.getProducer()).getName()!=null)
			s=s+" > "+producerService.findOne(filter.getProducer()).getName();
		}
		if(filter.getPrice1()>0&&filter.getPrice1()<=4){
			
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/ukulele";
	}
	List<ProductInfo> ListPrice(int p1, List<ProductInfo> listukuleleInfo  ){
		List<ProductInfo> ukuleleInfo=new ArrayList<ProductInfo>();
		switch(p1){
		case 1: ukuleleInfo=productFilterDao.filterPrice(1,500000, listukuleleInfo);
		break;
		case 2: ukuleleInfo=productFilterDao.filterPrice(500000,1500000, listukuleleInfo);
		break;
		case 3: ukuleleInfo=productFilterDao.filterPrice(1500000,3000000, listukuleleInfo);
		break;
		case 4: ukuleleInfo=productFilterDao.filterPrice(3000000, listukuleleInfo);
		break;
		}
		return ukuleleInfo;
	}
	/*admin*/
	@GetMapping("/adukulelefilterCategory/{id}")
	public String FindCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE >LOẠI");
		return "/admin/UkuleleAd";
	}
	@GetMapping("/adukulelefilterProducer/{id}")
	public String adukuleleProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos",  productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE >HÃNG");
		return "/admin/UkuleleAd";
	}

	
	@GetMapping("/adukulelefilterPrice/{p1}")
	public String aadukulele1pricer(Model model, @PathVariable int p1) {
		
		
		
	
		
		model.addAttribute("infos",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterUkulele)));
		AddAtribute(model);
		model.addAttribute("tittle", "UKULELE");
		return "/admin/UkuleleAd";
	}
	@GetMapping("/adukulelefilter")
	public String afilter(Model model, @Valid ProductFillter filter) {
		String s="UKULELE";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterUkulele);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
		
			return "admin/UkuleleAd";
		}
		if(filter.getCategory2()>0){
			list=productFilterDao.filterCategory(filter.getCategory2(), list);
			s=s+" > "+category2Service.findOne(filter.getCategory2()).getCategory();
		}
		
		if(filter.getProducer()>0){
			list=productFilterDao.filterProducer(filter.getProducer(), list);
			s=s+" > "+producerService.findOne(filter.getProducer()).getName();
		}
		if(filter.getPrice1()>0&&filter.getPrice1()<=4){
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/admin/UkuleleAd";
	}

}
