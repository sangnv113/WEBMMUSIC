package com.example.WebProject.service;

import com.example.WebProject.entity.Ma;

public interface MaService {
	 Ma findOne(int id);
	 void save(Ma contact);
}
