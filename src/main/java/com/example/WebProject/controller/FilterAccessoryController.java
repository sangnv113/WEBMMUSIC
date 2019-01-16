
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
public class FilterAccessoryController {
	@Autowired
	private ProductFilterDao productFilterDao;
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	
	private ProducerService producerService;
	
	@Autowired
	private Category2Service category2Service;
	
	private void AddAtribute(Model model){ //  in this class this function be showed all other func
		model.addAttribute("filter", new ProductFillter(-1, -1, -1, -1));
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterAccessory));
		model.addAttribute("categories", category2Service.findByIdcpContaining(WebProjectApplication.filterAccessory));
		model.addAttribute("prnumber", WebProjectApplication.productNumber);
		
	}
	@GetMapping("/accessoryfilterCategory/{id}")
	public String adaccessoryacousticCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN >LOẠI");
		return "/accessory";
	}
	@GetMapping("/accessoryfilterProducer/{id}")
	public String adaccessoryacousticProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN >HÃNG");
		return "/accessory";
	}
	
	
	@GetMapping("/accessoryfilterPrice/{p1}")
	public String adaccessory1pricer(Model model, @PathVariable int p1) {
		
		model.addAttribute("infos", ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN");
		return "/accessory";
	}
	@GetMapping("/accessoryfilter")
	public String filter(Model model, @Valid ProductFillter filter) {
		String s="PHỤ KIỆN";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterAccessory);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
			model.addAttribute("tittle", "PHỤ KIỆN ");
			return "accessory";
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
			
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/accessory";
	}
	List<ProductInfo> ListPrice(int p1, List<ProductInfo> listaccessoryInfo  ){
		List<ProductInfo> accessoryInfo=new ArrayList<ProductInfo>();
		switch(p1){
		case 1: accessoryInfo=productFilterDao.filterPrice(1,100000, listaccessoryInfo);
		break;
		case 2: accessoryInfo=productFilterDao.filterPrice(100000,300000, listaccessoryInfo);
		break;
		case 3: accessoryInfo=productFilterDao.filterPrice(300000,500000, listaccessoryInfo);
		break;
		case 4: accessoryInfo=productFilterDao.filterPrice(500000, listaccessoryInfo);
		break;
		}
		return accessoryInfo;
	}
	/*admin*/
	@GetMapping("/adaccessoryfilterCategory/{id}")
	public String FindCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN >LOẠI");
		return "/admin/AccessoryAd";
	}
	@GetMapping("/adaccessoryfilterProducer/{id}")
	public String adaccessoryProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos",  productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN >HÃNG");
		return "/admin/AccessoryAd";
	}

	
	@GetMapping("/adaccessoryfilterPrice/{p1}")
	public String aadaccessory1pricer(Model model, @PathVariable int p1) {
		
		
		
	
		
		model.addAttribute("infos",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterAccessory)));
		AddAtribute(model);
		model.addAttribute("tittle", "PHỤ KIỆN");
		return "/admin/AccessoryAd";
	}
	@GetMapping("/adaccessoryfilter")
	public String afilter(Model model, @Valid ProductFillter filter) {
		String s="PHỤ KIỆN";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterAccessory);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
		
			return "admin/AccessoryAd";
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
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/admin/AccessoryAd";
	}

}
