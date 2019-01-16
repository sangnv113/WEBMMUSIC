
package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.CommentRate;
import com.example.WebProject.entity.CommentRateIndentity;

public interface CommentRateService {

	Iterable<CommentRate> findAll();

 
	CommentRate findOne(CommentRateIndentity id);

    void save(CommentRate contact);

    void delete(CommentRateIndentity id);

	/*List<CommentRate> search(String q);*/

}
