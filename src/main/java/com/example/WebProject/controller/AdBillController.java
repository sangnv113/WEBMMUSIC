
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

import com.example.WebProject.entity.Customer;
import com.example.WebProject.entity.Producer;
import com.example.WebProject.repository.AccountRepository;
import com.example.WebProject.dao.BillDao;
import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.CartLineInfoIndentity;
import com.example.WebProject.entity.Color;
import com.example.WebProject.service.CartInfoService;
import com.example.WebProject.service.CartLineInfoService;
import com.example.WebProject.service.CustomerService;
import com.example.WebProject.service.ProductService;
import com.example.WebProject.validator.EditColorValidator;
import com.example.WebProject.validator.EditProducerValidator;


@Controller
public class AdBillController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartInfoService cartService;
	@Autowired
	private BillDao billDao;
	@Autowired
	private ProductService productService;
	 
	@Autowired
	
	private CartLineInfoService cartLineInfoService;
	
	
	
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
	 
	       
	        if (target.getClass() == Producer.class) {
	            dataBinder.setValidator(editProducerValidator); 
	        }
	        if (target.getClass() == Color.class) {
	            dataBinder.setValidator(editColorValidator); 
	        }
	    }
	
	/*account controller*/
	

	/*view customer*/
	@GetMapping("/adcustomer")
	public String adcustomer(Model model) {
		
		model.addAttribute("tittle", "THÔNG TIN TÀI KHOẢN");
		model.addAttribute("infos", customerService.findAll());
		return "/admin/CustomerAd";
	}


	/*edit customer*/
	@GetMapping("/adcustomer/{id}/edit")
	public String edit(@PathVariable String id, Model model) {
	
		model.addAttribute("contact", customerService.findOne(id));
		return "/admin/CustomerEdit";
	}
	@PostMapping("/adcustomer/save")
	public String save ( Model model, @ModelAttribute("contact") @Validated Customer contact, BindingResult result, 
			RedirectAttributes redirect ) {
		if (result.hasErrors()) {
			
			
			return "/admin/CustomerEdit";
		}
		
		
		customerService.save(contact);
		//customerService.save(customer);
		redirect.addFlashAttribute("success", "Saved customer successfully!");
		return "redirect:/adcustomer";
	}
	@GetMapping("/adcustomer/create")
	public String create( Model model) {
		Customer gt=new Customer();
		
		
	
		model.addAttribute("contact",gt );
		return "/admin/CustomerEdit";
	}
	
	@GetMapping("/adcustomer/{id}/delete")
	public String delete(@PathVariable String id, RedirectAttributes redirect) {
		
		customerService.delete(id);
	
		redirect.addFlashAttribute("success", "Deleted customer successfully!");
		return "redirect:/adcustomer";
	}
	
	
//cart
	
	/*view cart*/
	@GetMapping("/adcart")
	public String adcart(Model model) {
		
		model.addAttribute("tittle", "THÔNG TIN HÓA ĐƠN");
		model.addAttribute("infos", billDao.findAllOrder());
		return "/admin/CartAd";
	}
	@GetMapping("/adcartView/{id}")
	public String adcartview(Model model, @PathVariable int id) {
		
		model.addAttribute("tittle", "THÔNG TIN HÓA ĐƠN");
		model.addAttribute("infos", billDao.findBillConfirm(id));
		return "/admin/CartAd";
	}
	@GetMapping("/adcartConfirm/{id}")
	public String confirm(@PathVariable int id,  RedirectAttributes redirect) {
		redirect.addFlashAttribute("success", "Đã xác nhận hóa đơn thành công!");
		CartInfo cinfo=new CartInfo();
		 cinfo= cartService.findOne(id);
		cinfo.setDone(1);
		cartService.save(cinfo);
	
		return "redirect:/adcart";
	}
	@GetMapping("/adcartPaid/{id}")
	public String paymentpaid(@PathVariable int id,  RedirectAttributes redirect) {
		redirect.addFlashAttribute("success", "Đã xác nhận thanh toán thành công!");
		CartInfo cinfo=new CartInfo();
		 cinfo= cartService.findOne(id);
		cinfo.setDone(2);
		cartService.save(cinfo);
		return "redirect:/adcart";
	}


	
	
	@GetMapping("/adcart/{id}/delete")
	public String deletec(@PathVariable int id, RedirectAttributes redirect) {
		
		cartService.delete(id);
	
		redirect.addFlashAttribute("success", "Deleted cart successfully!");
		return "redirect:/adcart";
	}
//	
//	show bill detail
//	
//	
	@GetMapping("/adcartline/{id}")
	public String adcartline(@PathVariable int id, Model model) {
		
		model.addAttribute("infos", billDao.findBillDetail(id));
		return "/admin/CartLineAd";
	}
	
	@GetMapping("/adcartline/{id}/{id2}/delete")// id: id product, id2: id cartinfo
	public String deletecl(@PathVariable int id, @PathVariable int id2,  Model model) {
		CartLineInfoIndentity clii=new CartLineInfoIndentity( cartService.findOne(id2), productService.findOne(id)) ;
		cartLineInfoService.delete(clii);
	
		model.addAttribute("success", "Deleted cart successfully!");
		model.addAttribute("infos", billDao.findBillDetail(id2));
		return "/admin/CartLineAd";
	}
	
	

	}
