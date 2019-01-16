package com.example.WebProject.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.WebProject.WebProjectApplication;
import com.example.WebProject.dao.BillDao;
import com.example.WebProject.dao.ProductDao;
import com.example.WebProject.dao.ProductFilterDao;
import com.example.WebProject.entity.Comment;
import com.example.WebProject.model.CommentModel;
import com.example.WebProject.model.ProductFillter;
import com.example.WebProject.service.Category2Service;
import com.example.WebProject.service.CommentService;
import com.example.WebProject.service.ProductService;

@Controller
public class AdViewController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ProductFilterDao productFilterDao;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BillDao billDao;
	@Autowired
	private Category2Service category2Service;
	@Autowired
	private Category2Service categoryService;

	private void PrAddModel(Model model) {
		model.addAttribute("filter", new ProductFillter(-1, -1, -1, -1));

	}

	private void AddNotify(Model model) {
		model.addAttribute("notconfirm", billDao.CountBill(0));
		model.addAttribute("confirmed", billDao.CountBill(1));
		model.addAttribute("comment", commentService.findByNoteContaining(0).size());
	}
	@GetMapping("/notifycomment")
	public String notify(Model model) {
		AddNotify(model);
		model.addAttribute("comments",commentService.findByNoteContaining(0));
		
		return "/admin/_notify";
	}
	@GetMapping("/seencomment/{id}")
	public String seenComment(@PathVariable int id, Model model, RedirectAttributes redirect) {
		Comment cmt=commentService.findOne(id);
		cmt.setNote(1);
		commentService.save(cmt);
		redirect.addFlashAttribute("success", "Đã đánh dấu!");
		return "redirect:/notifycomment";
	
	}

	
	@GetMapping("/_")
	public String index(Model model) {
		AddNotify(model);
		model.addAttribute("guitars", productDao.listProductInfo(WebProjectApplication.filterGuitar));
		model.addAttribute("pianos", productDao.listProductInfo(WebProjectApplication.filterPiano));
		model.addAttribute("drums", productDao.listProductInfo(WebProjectApplication.filterDrum));
		model.addAttribute("ukuleles", productDao.listProductInfo(WebProjectApplication.filterUkulele));

		return "/admin/_home";
	}

	@GetMapping("/_guitar")
	public String bbb(Model model) {
		AddNotify(model);
		model.addAttribute("tittle", "GUITAR");

		model.addAttribute("guitars", productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
		PrAddModel(model);

		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterGuitar));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterGuitar));

		return "/admin/_guitar";
	}

	@GetMapping("/_ukulele")
	public String Ukulele(Model model) {
		model.addAttribute("tittle", "UKULELE");
		PrAddModel(model);
		AddNotify(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterUkulele));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterUkulele));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));

		return "/admin/_ukulele";
	}

	@GetMapping("/_piano")
	public String Piano(Model model) {
		model.addAttribute("tittle", "PIANO");
		PrAddModel(model);
		AddNotify(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterPiano));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterPiano));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterPiano));

		return "/admin/_piano";
	}

	@GetMapping("/_drum")
	public String Drum(Model model) {
		model.addAttribute("tittle", "TRỐNG");
		PrAddModel(model);
		AddNotify(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterDrum));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterDrum));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterDrum));

		return "/admin/_drum";
	}

	@GetMapping("/_flute")
	public String uku(Model model) {
		model.addAttribute("tittle", "SÁO TRÚC");
		PrAddModel(model);
		AddNotify(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterFlute));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterFlute));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterFlute));
		return "/admin/_flute";
	}

	//
	@GetMapping("/_accessory")
	public String acc(Model model) {
		model.addAttribute("tittle", "PHỤ KIỆN");
		PrAddModel(model);
		AddNotify(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterAccessory));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterAccessory));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
		return "/admin/_accessory";
	}
	//

	@GetMapping("/_product/{id}")
	public String Show1item(@PathVariable int id, Model model) {
		AddNotify(model);
		ShowProduct(model, id);

		return "/admin/AdViewProduct";
	}

	void ShowProduct(Model model, int id) {// add model to show page product
											// admin
		model.addAttribute("info", productDao.findProductInfo(id));
		model.addAttribute("commentrate", productDao.Get10Comment(id));

		// comment
		Set<Comment> scomment = productService.findOne(id).getComment();// get
																		// set
																		// comment
		model.addAttribute("comments", scomment);// many comments to display
		// add id product into id comment to save then set value right with
		// entity Ma
		CommentModel cmt = new CommentModel(id);
		cmt.setName("SMUSIC");
		cmt.setPhone("1111111111");
		model.addAttribute("onecomment", cmt);// one comment to
												// save
		model.addAttribute("totalcomment", scomment.size());// one comment to
															// save
	}

	@GetMapping("/adcomment/{id}/delete") /* id1: id product, id2 id comment */
	public String Color(@PathVariable int id, RedirectAttributes redirect) {
		commentService.delete(id);

		redirect.addFlashAttribute("success", "Xóa bình luận thành công!");
		return "redirect:/result";
	}

	@GetMapping("/result")
	public String Result() {

		return "/result";
	}

	///////////////////////////////////////////
	// view
	private void AddAtribute(Model model, int id) {// id: id category of product
		model.addAttribute("filter", new ProductFillter(-1, -1, -1, -1));
		model.addAttribute("producers", productFilterDao.list5Producer(id));
		model.addAttribute("categories", category2Service.findByIdcpContaining(id));
	}

	/* view accessory */
	@GetMapping("/adaccessory")
	public String adaccessory(Model model) {
		AddAtribute(model, WebProjectApplication.filterAccessory);
		AddNotify(model);
		model.addAttribute("tittle", "PHỤ KIỆN");
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
		return "/admin/AccessoryAd";
	}

	/* view drum */
	@GetMapping("/addrum")
	public String addrum(Model model) {
		AddAtribute(model, WebProjectApplication.filterDrum);
		AddNotify(model);
		model.addAttribute("tittle", "TRỐNG");
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
		return "/admin/DrumAd";
	}

	/* view flute */
	@GetMapping("/adflute")
	public String adflute(Model model) {
		AddAtribute(model, WebProjectApplication.filterFlute);
		AddNotify(model);
		model.addAttribute("tittle", "SÁO TRÚC");
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterFlute));
		return "/admin/FluteAd";
	}

	/* view guitar */
	@GetMapping("/adguitar")
	public String adguitar(Model model) {
		AddAtribute(model, WebProjectApplication.filterGuitar);
		AddNotify(model);
		model.addAttribute("tittle", "GUITAR");
		model.addAttribute("guitars", productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
		return "/admin/GuitarAd";
	}

	/* view piano */
	@GetMapping("/adpiano")
	public String adpiano(Model model) {
		AddAtribute(model, WebProjectApplication.filterPiano);
		AddNotify(model);
		model.addAttribute("tittle", "PIANO");
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
		return "/admin/PianoAd";
	}

	/* view ukulele */
	@GetMapping("/adukulele")
	public String adukulele(Model model) {
		AddAtribute(model, WebProjectApplication.filterUkulele);
		AddNotify(model);
		model.addAttribute("tittle", "UKULELE");
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
		return "/admin/UkuleleAd";
	}
}
