
package com.example.WebProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.WebProject.WebProjectApplication;
import com.example.WebProject.dao.ProductDao;
import com.example.WebProject.entity.Producer;
import com.example.WebProject.model.ProductInfo;
import com.example.WebProject.entity.Color;
import com.example.WebProject.service.Category2Service;
import com.example.WebProject.service.CategoryService;
import com.example.WebProject.service.ColorService;
import com.example.WebProject.service.MaService;
import com.example.WebProject.service.ProducerService;
import com.example.WebProject.service.ProductService;
import com.example.WebProject.validator.EditColorValidator;
import com.example.WebProject.validator.EditProducerValidator;
import com.example.WebProject.validator.EditProductValidator;


@Controller
public class AdAccessoryController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDao productDao;
	@Autowired
	
	private ColorService colorService;
	@Autowired
	
	private ProducerService producerService;
	@Autowired
	
	private MaService maService;

	@Autowired
	private Category2Service category2Service;
	@Autowired
	private CategoryService categoryService;
	 @Autowired
	    private EditProductValidator editProductValidator;
	 @Autowired
	    private EditProducerValidator editProducerValidator;
	 @Autowired
	    private EditColorValidator editColorValidator;
	 
	    @InitBinder
	    public void myInitBinder(WebDataBinder dataBinder) {
	        Object target = dataBinder.getTarget();
	        if (target == null) {
	            return;
	        }
	        System.out.println("Target=" + target);
	 
	        if (target.getClass() == ProductInfo.class) {
	            dataBinder.setValidator(editProductValidator); 
	        }
	        if (target.getClass() == Producer.class) {
	            dataBinder.setValidator(editProducerValidator); 
	        }
	        if (target.getClass() == Color.class) {
	            dataBinder.setValidator(editColorValidator); 
	        }
	    }
	
	 
	    private void AddCategoryColorProduct(Model model) {
			model.addAttribute("categoris", category2Service.findByIdcpContaining(WebProjectApplication.filterAccessory));
			model.addAttribute("colors", colorService.findAll());
			model.addAttribute("producers", producerService.findByIdprContaining(WebProjectApplication.filterAccessory));

		}
	

	


	/*edit accessory*/
	@GetMapping("/adaccessory/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("filter",WebProjectApplication.filterAccessory);
		model.addAttribute("contact",  productDao.findProductInfoSave(id));
		AddCategoryColorProduct(model);
	
		return "/admin/AccessoryEdit";
	}
	@PostMapping("/adaccessory/save")
	public String save ( Model model, @ModelAttribute("contact") @Validated ProductInfo contact, BindingResult result, 
			RedirectAttributes redirect ) {
		if (result.hasErrors()) {
			contact.setValid(false);
			AddCategoryColorProduct(model);
			return "/admin/AccessoryEdit";
		}
		/*if(contact.getFileData().isEmpty()){
			contact.setFileData(productService.findOne(contact.getId()).getImage());
		}*/
		contact.setValid(true);
		productDao.save(contact);
		//productService.save(accessory);
		redirect.addFlashAttribute("success", "Saved accessory successfully!");
		return "redirect:/adaccessory";
	}
	@GetMapping("/adaccessory/create")
	public String create( Model model) {
		ProductInfo gt=new ProductInfo();
		
		
		gt.setId(maService.findOne(1).getProduct());
		gt.setRate(0);
		gt.setLuotdanhgia(0);
		gt.setCategory(categoryService.findOne(WebProjectApplication.filterAccessory).getCategory());
		model.addAttribute("filter",WebProjectApplication.filterAccessory);
		model.addAttribute("contact",gt );
		AddCategoryColorProduct(model);
		return "/admin/AccessoryCreate";
	}
	@PostMapping("/adaccessory/savecreate")
	public String saveCreate(Model model, @ModelAttribute("contact") @Validated ProductInfo contact, BindingResult result, 
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			contact.setValid(false);
			AddCategoryColorProduct(model);
			
			return "/admin/AccessoryCreate";
		}
		contact.setValid(true);
		productDao.SaveCreate(contact);
		//productService.save(accessory);
		redirect.addFlashAttribute("success", "Saved accessory successfully!");
		return "redirect:/adaccessory";
	}
	@GetMapping("/adaccessory/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		
		productService.delete(id);
	
		redirect.addFlashAttribute("success", "Deleted accessory successfully!");
		return "redirect:/adaccessory";
	}
	
	

	}
