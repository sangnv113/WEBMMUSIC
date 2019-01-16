
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
public class FilterDrumController {
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
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterDrum));
		model.addAttribute("categories", category2Service.findByIdcpContaining(WebProjectApplication.filterDrum));
		model.addAttribute("prnumber", WebProjectApplication.productNumber);
		
	}
	@GetMapping("/drumfilterCategory/{id}")
	public String addrumacousticCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG >LOẠI");
		return "/drum";
	}
	@GetMapping("/drumfilterProducer/{id}")
	public String addrumacousticProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG >HÃNG");
		return "/drum";
	}
	
	
	@GetMapping("/drumfilterPrice/{p1}")
	public String addrum1pricer(Model model, @PathVariable int p1) {
		
		model.addAttribute("infos", ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG");
		return "/drum";
	}
	@GetMapping("/drumfilter")
	public String filter(Model model, @Valid ProductFillter filter) {
		String s="TRỐNG";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterDrum);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
			model.addAttribute("tittle", "TRỐNG ");
			return "drum";
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
			
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/drum";
	}
	List<ProductInfo> ListPrice(int p1, List<ProductInfo> listdrumInfo  ){
		List<ProductInfo> drumInfo=new ArrayList<ProductInfo>();
		switch(p1){
		case 1: drumInfo=productFilterDao.filterPrice(1,5000000, listdrumInfo);
		break;
		case 2: drumInfo=productFilterDao.filterPrice(5000000,15000000, listdrumInfo);
		break;
		case 3: drumInfo=productFilterDao.filterPrice(15000000,30000000, listdrumInfo);
		break;
		case 4: drumInfo=productFilterDao.filterPrice(30000000, listdrumInfo);
		break;
		}
		return drumInfo;
	}
	/*admin*/
	@GetMapping("/addrumfilterCategory/{id}")
	public String FindCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG >LOẠI");
		return "/admin/DrumAd";
	}
	@GetMapping("/addrumfilterProducer/{id}")
	public String addrumProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos",  productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG >HÃNG");
		return "/admin/DrumAd";
	}

	
	@GetMapping("/addrumfilterPrice/{p1}")
	public String aaddrum1pricer(Model model, @PathVariable int p1) {
		
		
		
	
		
		model.addAttribute("infos",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterDrum)));
		AddAtribute(model);
		model.addAttribute("tittle", "TRỐNG");
		return "/admin/DrumAd";
	}
	@GetMapping("/addrumfilter")
	public String afilter(Model model, @Valid ProductFillter filter) {
		String s="TRỐNG";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterDrum);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
		
			return "admin/DrumAd";
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
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/admin/DrumAd";
	}

}
