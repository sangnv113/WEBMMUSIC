package com.example.WebProject.service;

import java.util.List;

import com.example.WebProject.entity.Producer;

public interface ProducerService {

	Iterable<Producer> findAll();

    List<Producer> search(String q);

    Producer findOne(int id);

    void save(Producer contact);
    List<Producer> findByIdprContaining(int q);
    void delete(int id);
    List<Producer> findByNameContaining(String q);
}

