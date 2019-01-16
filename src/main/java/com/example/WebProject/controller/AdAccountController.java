package com.example.WebProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.WebProject.entity.Account;
import com.example.WebProject.entity.Customer;
import com.example.WebProject.repository.AccountRepository;


import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/aduser")
public class AdAccountController {
	 @Autowired
	    private AccountRepository accountService;
	
    /*view account*/
		@GetMapping
		public String account(Model model) {
			
			model.addAttribute("tittle", "THÔNG TIN TÀI KHOẢN");
			model.addAttribute("infos", accountService.findAll());
			return "/admin/UserAd";
		}
		
		@GetMapping("/changepassword")
		public String changepass(Model model) {
			
			model.addAttribute("tittle", "THÔNG TIN TÀI KHOẢN");
			model.addAttribute("infos", accountService.findAll());
			return "/admin/ChangePass";
		}
		
		@GetMapping("/{id}/edit")
		public String edit(@PathVariable String id, Model model) {
		
			model.addAttribute("contact", accountService.findOne(id));
			return "/admin/UserEdit";
		}
		@GetMapping("/{id}/delete")
		public String delete(@PathVariable String id, Model model, 
				RedirectAttributes redirect ) {
			
			accountService.delete(id);
			redirect.addFlashAttribute("success", "Đã xóa tài khoản thành công!");
			return "redirect:/aduser";
		}
		@GetMapping("/create")
		public String create( Model model) {
			Account gt=new Account();
			
			
		
			model.addAttribute("contact",gt );
			return "/admin/UserEdit";
		}
		@PostMapping("/save")
		public String save ( Model model, @ModelAttribute("contact") @Valid Account contact, BindingResult result, 
				RedirectAttributes redirect ) {
			if (result.hasErrors()) {
				
				
				return "/admin/UserEdit";
			}
//			set other values
			contact.setEncrytedPassword(BCrypt.hashpw(contact.getEncrytedPassword(), BCrypt.gensalt(5)));
			System.out.println("BCrypt hash: " + contact.getEncrytedPassword());
			
			contact.setActive(true);
			contact.setUserRole("ROLE_EMPLOYEE");
			
			accountService.save(contact);
			redirect.addFlashAttribute("success", "Saved customer successfully!");
			return "redirect:/aduser";
		}
}
