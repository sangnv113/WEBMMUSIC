package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Comment;
import com.example.WebProject.entity.Producer;

public interface ProducerRepository extends CrudRepository<Producer, Integer> {

	 List<Producer> findByNameContaining(String q);
	 public List<Producer> findProducersByIdpr(int q);
}
