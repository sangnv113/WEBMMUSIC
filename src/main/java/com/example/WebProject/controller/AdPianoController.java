
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
import com.example.WebProject.dao.ProductFilterDao;
import com.example.WebProject.entity.Producer;
import com.example.WebProject.model.ProductFillter;
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
public class AdPianoController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductFilterDao productFilterDao;
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
		model.addAttribute("categoris", category2Service.findByIdcpContaining(WebProjectApplication.filterPiano));
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("producers", producerService.findByIdprContaining(WebProjectApplication.filterPiano));

	}

	

	/* edit piano */
	@GetMapping("/adpiano/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("filter", WebProjectApplication.filterPiano);
		model.addAttribute("contact", productDao.findProductInfoSave(id));
		AddCategoryColorProduct(model);

		return "/admin/PianoEdit";
	}

	@PostMapping("/adpiano/save")
	public String save(Model model, @ModelAttribute("contact") @Validated ProductInfo contact, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			contact.setValid(false);
			AddCategoryColorProduct(model);
			return "/admin/PianoEdit";
		}

		contact.setValid(true);
		productDao.save(contact);
		// productService.save(piano);
		redirect.addFlashAttribute("success", "Saved piano successfully!");
		return "redirect:/adpiano";
	}

	@GetMapping("/adpiano/create")
	public String create(Model model) {
		ProductInfo gt = new ProductInfo();

		gt.setId(maService.findOne(1).getProduct());
		gt.setRate(0);
		gt.setLuotdanhgia(0);
		gt.setCategory(categoryService.findOne(WebProjectApplication.filterPiano).getCategory());
		model.addAttribute("filter", WebProjectApplication.filterPiano);
		model.addAttribute("contact", gt);
		AddCategoryColorProduct(model);
		return "/admin/PianoCreate";
	}

	@PostMapping("/adpiano/savecreate")
	public String saveCreate(Model model, @ModelAttribute("contact") @Validated ProductInfo contact,
			BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			contact.setValid(false);
			AddCategoryColorProduct(model);

			return "/admin/PianoCreate";
		}
		contact.setValid(true);
		productDao.SaveCreate(contact);
		// productService.save(piano);
		redirect.addFlashAttribute("success", "Saved piano successfully!");
		return "redirect:/adpiano";
	}

	@GetMapping("/adpiano/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {

		
		productService.delete(id);

		redirect.addFlashAttribute("success", "Deleted piano successfully!");
		return "redirect:/adpiano";
	}

}
