package com.example.WebProject.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.entity.CartInfo;
import com.example.WebProject.entity.CartLineInfo;
import com.example.WebProject.model.BillInfo;
import com.example.WebProject.model.CartLineModel;
import com.example.WebProject.service.CartInfoService;
import com.example.WebProject.service.CartLineInfoService;

@Transactional
@Repository

public class BillDao {
	@Autowired
	private CartInfoService cartInfoService;
	@Autowired
	private CartLineInfoService cartLineInfoService;

	//
	// count number of cartinfos with idconfirm
	//
	public int CountBill(int idConfirm) {
		int n = 0;
		for (CartInfo cif : cartInfoService.findAll()) {
			if (cif.getDone() == idConfirm) {
				n += 1;
			}
		}
		return n;
	}

	//
	//
	// fill all cart info add into model to display on adminpage
	//
	//
	//
	public List<BillInfo> findAllOrder() {

		try {
			List<BillInfo> listresult = new ArrayList<BillInfo>();
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
			BillInfo gtinfo;

			for (CartInfo ci : cartInfoService.findAll()) {

				gtinfo = new BillInfo(ci.getId(), ci.getIdcustomer().getName(), ci.getIdcustomer().getPhone(),
						ci.getIdcustomer().getEmail(), ci.getIdcustomer().getAddress(), ci.getDone(),
						ProductDao.intien(String.valueOf(ci.getAmount())), ci.getNum());

				if (ci.getDate() != null) {
					gtinfo.setDate(formatter.format(ci.getDate()).toString());
				}
				switch (ci.getDone()) {
				case 0:
					gtinfo.setStatus("Chưa xác nhận");
					break;
				case 1:
					gtinfo.setStatus("Đã xác nhận");
					break;
				case 2:
					gtinfo.setStatus("Đã thanh toán");
					break;

				}

				listresult.add(gtinfo);

			}

			return listresult;
		} catch (NoResultException e) {
			return null;
		}
	}

	// find bill base number of confirmation

	public List<BillInfo> findBillConfirm(int numberComfirm) {

		try {
			List<BillInfo> listresult = new ArrayList<BillInfo>();
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
			BillInfo gtinfo;

			for (CartInfo ci : cartInfoService.findAll()) {
				if (ci.getDone() == numberComfirm) {
					gtinfo = new BillInfo(ci.getId(), ci.getIdcustomer().getName(), ci.getIdcustomer().getPhone(),
							ci.getIdcustomer().getEmail(), ci.getIdcustomer().getAddress(), ci.getDone(),
							ProductDao.intien(String.valueOf(ci.getAmount())), ci.getNum());

					if (ci.getDate() != null) {
						gtinfo.setDate(formatter.format(ci.getDate()).toString());
					}
					switch (ci.getDone()) {
					case 0:
						gtinfo.setStatus("Chưa xác nhận");
						break;
					case 1:
						gtinfo.setStatus("Đã xác nhận");
						break;
					case 2:
						gtinfo.setStatus("Đã thanh toán");
						break;

					}

					listresult.add(gtinfo);

				}
			}
			return listresult;
		} catch (NoResultException e) {
			return null;
		}
	}

////	
//	
//	
//	
//	?????????????????????????????????????
//		not optimize 	
//			
//			
//			
//			
	public List<CartLineModel> findBillDetail(int idCart) {

		try {
			List<CartLineModel> listresult = new ArrayList<CartLineModel>();

			CartLineModel gtinfo;

			for (CartLineInfo ci : cartLineInfoService.findAll()) {
				if (ci.getId().getCartinfo().getId() == idCart) {
					gtinfo = new CartLineModel(ci.getId().getProduct().getId(),idCart, ci.getId().getProduct().getName(),
							ci.getId().getProduct().getCategory2id().getCategory(),
							ci.getId().getProduct().getProducerid().getName(),
							ci.getId().getProduct().getColorid().getName(), ci.getNum(),
							ProductDao.intien(ci.getId().getProduct().getGiasaugiam()));

					listresult.add(gtinfo);
				}
			}

			return listresult;
		} catch (NoResultException e) {
			return null;
		}
	}

}
