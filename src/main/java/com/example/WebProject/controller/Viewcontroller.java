
package com.example.WebProject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.WebProject.WebProjectApplication;

import com.example.WebProject.dao.ProductDao;
import com.example.WebProject.dao.ProductFilterDao;

import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.Customer;

import com.example.WebProject.entity.Ma;
import com.example.WebProject.entity.Products;
import com.example.WebProject.entity.CartLineInfo;
import com.example.WebProject.entity.CartLineInfoIndentity;
import com.example.WebProject.entity.CartLineInfoView;
import com.example.WebProject.entity.Comment;
import com.example.WebProject.entity.CommentRate;
import com.example.WebProject.entity.CommentRateIndentity;
import com.example.WebProject.model.CartLineModel;
import com.example.WebProject.model.CommentModel;
import com.example.WebProject.model.ProductFillter;
import com.example.WebProject.model.ProductInfo;
import com.example.WebProject.model.RateModel;
import com.example.WebProject.service.CartInfoService;
import com.example.WebProject.service.CartLineInfoService;
import com.example.WebProject.service.Category2Service;
import com.example.WebProject.service.CategoryService;
import com.example.WebProject.service.CommentRateService;
import com.example.WebProject.service.CommentService;
import com.example.WebProject.service.CustomerService;

import com.example.WebProject.service.MaService;
import com.example.WebProject.service.ProductService;

@Controller
public class Viewcontroller {
	@Autowired
	private ProductFilterDao productFilterDao;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDao productDao;

	@Autowired
	private Category2Service categoryService;
	//
	@Autowired
	private CartInfoService cartInfoService;
	@Autowired
	private CartLineInfoService cartLineInfoService;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommentRateService commentRateService;
	@Autowired
	private MaService maService;
	
	@Autowired
	private CommentService commentService;

	private Ma ma;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private void AddProductNumber(Model model) {

		model.addAttribute("prnumber", WebProjectApplication.productNumber);

	}
	/* search */
	@GetMapping("/search")
	public String search(Model model, @Valid String search) {
		model.addAttribute("tittle", "kết quả cho "+search);

		model.addAttribute("guitars", productDao.Search(search));
		
		AddProductNumber(model);
		
		return "resultsearch";
	}
	
	
	//
	// id comment is idproduct, set value this to 1 var (idproduct)
	// then set id comment right and save into database
	//
	
	@PostMapping("/adcommentguitar")
	public String adrcomment(Model model, @Valid CommentModel onecomment) {
		
		
		
		onecomment.setNote(2);
		
		savecomment( onecomment,  model);
		return "/admin/AdViewProduct";
	}
	@PostMapping("/commentguitar")
	public String rcomment(Model model, @Valid CommentModel onecomment) {
		

		
		onecomment.setNote(0);
		System.out.println("active : "+onecomment.getNote());
		System.out.println(onecomment.getPhone());
		System.out.println(onecomment.getName());
		System.out.println(onecomment.getComment());
		
		savecomment( onecomment,  model);
		

		return "guitarproduct";
		/*redirect.addFlashAttribute("success", "Bình luận của bạn đã được gửi!");
		return "redirect:/result";*/
	}
	void savecomment(CommentModel onecomment, Model model){ //this product save comment and increase index
		int idprduct = onecomment.getId();
		Comment cmt = new Comment(onecomment.getName(), onecomment.getPhone(), onecomment.getComment(), onecomment.getNote());
		// set id
		ma = maService.findOne(1);
		cmt.setId(ma.getComment());
		ma = new Ma(1, ma.getProduct(), ma.getProducer(), ma.getColor(), ma.getCart(), ma.getCartline(),
				ma.getComment() + 1);
		maService.save(ma);
		//
		Date date = new Date();
		cmt.setDate(date);
		cmt.setProduct(productService.findOne(idprduct));
		if(onecomment.getName().length()>1&&onecomment.getComment().length()>=1)// check name and comment is validate
		{commentService.save(cmt);}
		ProductionProducts(model, idprduct, WebProjectApplication.filterGuitar);
	}

	//
	// rate product with comment
	// -check number phone are exist?
	// if right save and if false return page don't save
	//
	//
	@PostMapping("/rateguitar")
	public String rate(Model model, @Valid RateModel rate) {

		// check numberphone
		if (CheckPhoneNumberRight(rate, model)) {
			if (rate.getRate() == 0) {
				rate.setRate(10);
			}
			// int object andsave
			Products obj = productService.findOne(rate.getId());
			Customer ctm = customerService.findOne(rate.getPhone());
			CommentRateIndentity cri = new CommentRateIndentity(ctm, obj);//find primarikey
			if (obj.getSoluot() == 0) {
				obj.setRate(rate.getRate());
			} else {
				
				//  check phone number have rated this product ?
				CommentRate cmrCheck= commentRateService.findOne(cri);
				if(cmrCheck==null){
					//if not rated
					obj.setRate((obj.getRate() * obj.getSoluot() + rate.getRate()) / (obj.getSoluot() + 1));
				}
				else{//if rated
					
				obj.setRate((obj.getRate() * obj.getSoluot()-obj.getRate() + rate.getRate()) / (obj.getSoluot()));
				obj.setSoluot(obj.getSoluot() - 1);
				}
			}
			obj.setSoluot(obj.getSoluot() + 1);//always
			productService.save(obj);

			Date date = new Date();
			
			CommentRate commentRate = new CommentRate(cri, rate.getRate(), rate.getComment(), formatter.format(date));

			commentRateService.save(commentRate);
		}

		ProductionProducts(model, rate.getId(), WebProjectApplication.filterGuitar);

		return "guitarproduct";
	}

	private Boolean CheckPhoneNumberRight(RateModel rate, Model model) {// this fonc is check phone number correct
		Customer cst = customerService.findOne(rate.getPhone());
		if (cst == null) {
			model.addAttribute("success",
					"Không thành công!!! Số điện thoại của bạn chưa được sử dụng để đặt mặt hàng này");
			return false;
		}
		try{
		/*CartInfo cif=cartInfoService.findCartInfosByIdcustomer(cst).get(0);*/
			//find  cartinfo have phone number correct
		for(CartInfo cif:cartInfoService.findCartInfosByIdcustomer(cst))	{																//pn on model( for...???)
		for(CartLineInfoView clif: cif.getCartLineInfo()){//get cartlineinfos from cartinfo and compare index product
			System.out.println(clif.getProduct().getId());
			System.out.println(rate.getId());
			
			System.out.println("//");
			if(clif.getProduct().getId()==rate.getId()){//compare
				
				model.addAttribute("success",
						"thành công!!!");
				return true;
				
			}
		}
		}
		
		}catch(NoResultException e) {
			return null;
		}
		model.addAttribute("success",
				"Không thành công!!! Số điện thoại của bạn chưa được sử dụng để đặt mặt hàng này");
		return false;

	}

	@GetMapping("/")
	public String index(Model model) {
		AddProductNumber(model);
		model.addAttribute("guitars", productDao.listProductInfo(WebProjectApplication.filterGuitar));
		model.addAttribute("pianos", productDao.listProductInfo(WebProjectApplication.filterPiano));
		model.addAttribute("drums", productDao.listProductInfo(WebProjectApplication.filterDrum));
		model.addAttribute("ukuleles", productDao.listProductInfo(WebProjectApplication.filterUkulele));
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {

		return "login";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}

	// addmodel
	private void PrAddModel(Model model) {
		model.addAttribute("filter", new ProductFillter(-1, -1, -1, -1));

	}

	/* guitar */
	@GetMapping("/guitar")
	public String bbb(Model model) {
		model.addAttribute("tittle", "GUITAR");

		model.addAttribute("guitars", productDao.findAllInfoProduct(WebProjectApplication.filterGuitar));
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterGuitar));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterGuitar));

		return "guitar";
	}

	@GetMapping("/product_guitar/{id}")
	public String Show1item(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterGuitar);
		return "guitarproduct";
	}

	//
	// this function is load data of one product
	// -set visits
	// -load comment
	// -load rate
	// -load cartinfo
	// add id product into id comment to save then set value right with entity
	// Ma
	void ProductionProducts(Model model, int id, int codeProduct) {
		// info of the left menu

		PrAddModel(model);
		// info of left menu
		AddProductNumber(model);

		model.addAttribute("producers", productFilterDao.list5Producer(codeProduct));
		model.addAttribute("categories", categoryService.findByIdcpContaining(codeProduct));
		// set visits
		Products gti = productService.findOne(id);
		System.out.println(gti.getCategory2id().getCategory());
		gti.setVisits(gti.getVisits() + 1);
		productService.save(gti);
		// load info product
		ProductInfo gtinfo = productDao.findProductInfo(id);
		model.addAttribute("info", gtinfo);
	
		model.addAttribute("infos", productDao.listProductInfo(codeProduct));
		// info of cart
		CartLineModel cartLineInfos = new CartLineModel(gtinfo.getId(), gtinfo.getName(), gtinfo.getCategory(),
				gtinfo.getProducer(), gtinfo.getColor(), 1, gtinfo.getGiasaugiam());
		model.addAttribute("cartLineInfos", cartLineInfos);
		// comment rate
		model.addAttribute("ratemodel", new RateModel(id));
		model.addAttribute("commentrate", productDao.Get10Comment(id));

		// comment
		Set<Comment> scomment = productService.findOne(id).getComment();// get
																		
		model.addAttribute("comments", scomment);// many comments to display
		// add id product into id comment to save then set value right with
		// entity Ma
		model.addAttribute("onecomment", new CommentModel(id));// one comment to
																// save
		model.addAttribute("totalcomment", scomment.size());// one comment to
															// save

	}

	// piano
	@GetMapping("/piano")
	public String piano(Model model) {
		model.addAttribute("tittle", "PIANO");
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterPiano));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterPiano));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterPiano));
		return "piano";
	}

	@GetMapping("/product_piano/{id}")
	public String Show1itempia(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterPiano);
		return "pianoproduct";
	}

	/* ukulele */
	@GetMapping("/ukulele")
	public String ukulele(Model model) {
		model.addAttribute("tittle", "UKULELE");
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterUkulele));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterUkulele));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterUkulele));
		return "ukulele";
	}

	@GetMapping("/product_ukulele/{id}")
	public String Show1itemu(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterUkulele);
		return "ukuleleproduct";
	}

	/* FLUTE */
	@GetMapping("/flute")
	public String flute(Model model) {
		model.addAttribute("tittle", "SÁO TRÚC");
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterFlute));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterFlute));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterFlute));
		return "flute";
	}

	@GetMapping("/product_flute/{id}")
	public String Show1itempi(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterFlute);
		return "fluteproduct";
	}

	/* drum */
	@GetMapping("/drum")
	public String drum(Model model) {
		model.addAttribute("tittle", "TRỐNG");
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterDrum));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterDrum));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterDrum));
		return "drum";
	}

	@GetMapping("/product_drum/{id}")
	public String Show1itempid(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterDrum);
		return "drumproduct";
	}

	/* accessory */
	@GetMapping("/accessory")
	public String accessory(Model model) {
		model.addAttribute("tittle", "PHỤ KIỆN");
		PrAddModel(model);
		AddProductNumber(model);
		model.addAttribute("producers", productFilterDao.list5Producer(WebProjectApplication.filterAccessory));
		model.addAttribute("categories", categoryService.findByIdcpContaining(WebProjectApplication.filterAccessory));
		model.addAttribute("infos", productDao.findAllInfoProduct(WebProjectApplication.filterAccessory));
		return "accessory";
	}

	@GetMapping("/product_accessory/{id}")
	public String Show1itempiac(@PathVariable int id, Model model) {
		ProductionProducts(model, id, WebProjectApplication.filterAccessory);
		return "accessoryproduct";
	}

	// cart
	@PostMapping("/shoppingcart")
	public String cart(Model model, @Valid CartLineModel infoe) {
		AddProductNumber(model);
		if (infoe.getSoluong() > 0) {
			WebProjectApplication.productNumber += infoe.getSoluong();
			infoe.setIndex(WebProjectApplication.indexProduct);
			WebProjectApplication.indexProduct+=1;
			WebProjectApplication.listCartLine.add(infoe);
		}
		model.addAttribute("infos", WebProjectApplication.listCartLine);
		return "shoppingcart";
	}
	//delete cart line
		@GetMapping("/shoppingcartinfo/{id}/delete")
		public String deletecart(@PathVariable int id, Model model) {
			for(CartLineModel e:WebProjectApplication.listCartLine){
				if(e.getIndex()==id){
					WebProjectApplication.productNumber-=e.getSoluong();
					WebProjectApplication.listCartLine.remove(e);
					break;
				}
			}
			
			return "redirect:/shoppingcartinfo";
		}
//
//	view shoppingcart
//	
	@GetMapping("/shoppingcartinfo")
	public String cartinfo(Model model) {
		AddProductNumber(model);
	

		model.addAttribute("infos", WebProjectApplication.listCartLine);
		return "shoppingcart";
	}
	
	// page customer fill infomation
	@GetMapping("/infoCustomer")
	public String customer(Model model) {
		if(WebProjectApplication.productNumber<=0){
			return "redirect:/shoppingcartinfo";
		}
		model.addAttribute("contact", new Customer());
		return "infocustomer";
	}

	// save info of customer, cartinfo, cartlineinfo
	@PostMapping("/success")
	public String success(Model model, @Valid Customer contact) {
		// save customer
		customerService.save(contact);

		ma = maService.findOne(1);

		//
		// save cartinfo
		Date date = new Date();
		CartInfo cartInfo = new CartInfo(ma.getCart(), date, contact, 0, SumMoney(WebProjectApplication.listCartLine),
				WebProjectApplication.productNumber);
		cartInfoService.save(cartInfo);
		//
		// int new id for cartline and save
		//
		ma = new Ma(1, ma.getProduct(), ma.getProducer(), ma.getColor(), ma.getCart() + 1, ma.getCartline(),
				ma.getComment());
		maService.save(ma);

		// save cartlineinfo
		CartLineInfo cli;
		CartLineInfoIndentity cliId;
		
		for (CartLineModel clm :WebProjectApplication.listCartLine) {
			cliId=new CartLineInfoIndentity(cartInfo, productService.findOne(clm.getId()));
			cli = new CartLineInfo(cliId,  clm.getSoluong(),Integer.parseInt(productService.findOne(clm.getId()).getGiasaugiam())* clm.getSoluong() );
			
			cartLineInfoService.save(cli);
		
		}
		
//		
//		refresh list product bought
//		
		WebProjectApplication.listCartLine=new  ArrayList<CartLineModel>();
		WebProjectApplication.productNumber=0;
		return "success";
	}

	private int SumMoney(List<CartLineModel> list) {
		int s = 0;
		for (CartLineModel cmd : list) {
			s = s + Integer.parseInt(productService.findOne(cmd.getId()).getGiasaugiam()) * cmd.getSoluong();
		}
		return s;
	}

}
