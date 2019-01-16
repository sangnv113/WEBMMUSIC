
package com.example.WebProject.service;


import java.util.List;

import com.example.WebProject.entity.Comment;
import com.example.WebProject.model.CommentModel;


public interface CommentService {

	Iterable<Comment> findAll();

 
	Comment findOne(int id);

    void save(Comment contact);

    void delete(int id);

	 long count();
	 public List<CommentModel> findByNoteContaining(int q);

}
