package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Color;

public interface ColorRepository extends CrudRepository<Color, Integer> {

	 List<Color> findByNameContaining(String q);
}
