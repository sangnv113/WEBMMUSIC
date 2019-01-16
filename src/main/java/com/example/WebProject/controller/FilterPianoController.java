
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
public class FilterPianoController {
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
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterPiano));
		model.addAttribute("categories", category2Service.findByIdcpContaining(WebProjectApplication.filterPiano));
		model.addAttribute("prnumber", WebProjectApplication.productNumber);
		
	}
	@GetMapping("/pianofilterCategory/{id}")
	public String adpianoacousticCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO >LOẠI");
		return "/piano";
	}
	@GetMapping("/pianofilterProducer/{id}")
	public String adpianoacousticProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO >HÃNG");
		return "/piano";
	}
	
	
	@GetMapping("/pianofilterPrice/{p1}")
	public String adpiano1pricer(Model model, @PathVariable int p1) {
		
		model.addAttribute("infos", ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO");
		return "/piano";
	}
	@GetMapping("/pianofilter")
	public String filter(Model model, @Valid ProductFillter filter) {
		String s="PIANO";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterPiano);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
			model.addAttribute("tittle", "PIANO ");
			return "piano";
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
			
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/piano";
	}
	List<ProductInfo> ListPrice(int p1, List<ProductInfo> listpianoInfo  ){
		List<ProductInfo> pianoInfo=new ArrayList<ProductInfo>();
		switch(p1){
		case 1: pianoInfo=productFilterDao.filterPrice(1,5000000, listpianoInfo);
		break;
		case 2: pianoInfo=productFilterDao.filterPrice(5000000,15000000, listpianoInfo);
		break;
		case 3: pianoInfo=productFilterDao.filterPrice(15000000,30000000, listpianoInfo);
		break;
		case 4: pianoInfo=productFilterDao.filterPrice(30000000, listpianoInfo);
		break;
		}
		return pianoInfo;
	}
	/*admin*/
	@GetMapping("/adpianofilterCategory/{id}")
	public String FindCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("infos", productFilterDao.filterCategory(id, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO >LOẠI");
		return "/admin/PianoAd";
	}
	@GetMapping("/adpianofilterProducer/{id}")
	public String adpianoProducer(Model model, @PathVariable int id) {
		
		model.addAttribute("infos",  productFilterDao.filterProducer(id, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO >HÃNG");
		return "/admin/PianoAd";
	}

	
	@GetMapping("/adpianofilterPrice/{p1}")
	public String aadpiano1pricer(Model model, @PathVariable int p1) {
		
		
		
	
		
		model.addAttribute("infos",ListPrice(p1, productDao.findAllInfoProduct(WebProjectApplication.filterPiano)));
		AddAtribute(model);
		model.addAttribute("tittle", "PIANO");
		return "/admin/PianoAd";
	}
	@GetMapping("/adpianofilter")
	public String afilter(Model model, @Valid ProductFillter filter) {
		String s="PIANO";
		List<ProductInfo> list=productDao.findAllInfoProduct(WebProjectApplication.filterPiano);
		if(filter==null)
		{
			AddAtribute(model);
			model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
		
			return "admin/PianoAd";
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
			list=ListPrice(filter.getPrice1(), productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
			s=s+" > Giá";
		}
		
		model.addAttribute("infos", list);
		AddAtribute(model);
		model.addAttribute("tittle", s);
		return "/admin/PianoAd";
	}

}
