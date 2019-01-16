
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
import com.example.WebProject.service.CategoryService;
import com.example.WebProject.service.ProducerService;


@Controller
public class FilterGuitarController {
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
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterGuitar));
		model.addAttribute("categories", category2Service.findByIdcpContaining(WebProjectApplication.filterGuitar));
		model.addAttribute("prnumber", WebProjectApplication.productNumber);
		
	}
	
	@GetMapping("/guitarfilterCategory/{id}")
	public String adguitaracousticCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("guitars", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR >LOẠI");
		return "/guitar";
	}
	@GetMapping("/guitarfilterProducer/{id}")
	public String adguitaracousticProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("guitars", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR >HÃNG");
		return "/guitar";
	}
	
	
	@GetMapping("/guitarfilterPrice/{p1}")
	public String adguitar1pricer(Model model, @PathVariable int p1) {

		model.addAttribute("guitars",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR");
		return "/guitar";
	}
	@GetMapping("/guitarfilter")
	public String filter(Model model, @Valid ProductFillter filter) {
		String s="GUITAR";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterGuitar);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("guitars", productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
			model.addAttribute("tittle", "GUITAR ");
			return "guitar";
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
			
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
			s=s+" > Giá";
		}
		
		model.addAttribute("guitars", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/guitar";
	}
	List<ProductInfo> ListPrice(int p1, List<ProductInfo> listguitarInfo  ){
		List<ProductInfo> guitarInfo=new ArrayList<ProductInfo>();
		switch(p1){
		case 1: guitarInfo=productFilterDao.filterPrice(1,1500000, listguitarInfo);
		break;
		case 2: guitarInfo=productFilterDao.filterPrice(1500000,3000000, listguitarInfo);
		break;
		case 3: guitarInfo=productFilterDao.filterPrice(3000000,5000000, listguitarInfo);
		break;
		case 4: guitarInfo=productFilterDao.filterPrice(5000000, listguitarInfo);
		break;
		}
		return guitarInfo;
	}
	
	/*admin*/
	@GetMapping("/adguitarfilterCategory/{id}")
	public String FindCategory(Model model, @PathVariable int id) {
	
		model.addAttribute("guitars", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR >LOẠI");
		return "/admin/GuitarAd";
	}
	@GetMapping("/adguitarfilterProducer/{id}")
	public String adguitarProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("guitars", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR >HÃNG");
		return "/admin/GuitarAd";
	}

	
	@GetMapping("/adguitarfilterPrice/{p1}")
	public String aadguitar1pricer(Model model, @PathVariable int p1) {
		
		
		
	
		
		model.addAttribute("guitars",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterGuitar)));
		AddAtribute(model);
		model.addAttribute("tittle", "GUITAR");
		return "/admin/GuitarAd";
	}
	@GetMapping("/adguitarfilter")
	public String afilter(Model model, @Valid ProductFillter filter) {
		String s="GUITAR";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterGuitar);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("guitars", productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
			model.addAttribute("tittle", "GUITAR ");
			return "admin/GuitarAd";
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
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
			s=s+" > Giá";
		}
		
		model.addAttribute("guitars", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/admin/GuitarAd";
	}
		
}
