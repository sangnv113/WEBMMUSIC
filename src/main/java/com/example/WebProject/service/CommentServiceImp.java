

package com.example.WebProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebProject.entity.Comment;
import com.example.WebProject.entity.Products;
import com.example.WebProject.model.CommentModel;
import com.example.WebProject.model.ProductInfo;
import com.example.WebProject.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
    private CommentRepository commentRepository;
	 
	
	  @Override
	    public Iterable<Comment> findAll() {
	        return commentRepository.findAll();
	    }

	    @Override
	    public List<CommentModel> findByNoteContaining(int q) {//return comment model 
	    	List<CommentModel> listproduct = new ArrayList<CommentModel>();
	    	CommentModel cmtm;
	    	for (Comment cmt: commentRepository.findCommentsByNote(q)) { 
	    	cmtm=new CommentModel(cmt.getId(), cmt.getProduct().getId(), cmt.getComment(),
	    			cmt.getDate().toString(), cmt.getNote(), cmt.getName(), cmt.getPhone(), cmt.getProduct().getName());
	    	listproduct.add(cmtm);
	    	}
	    	return listproduct;
	    }

	    @Override
	    public Comment findOne(int id) {
	        return commentRepository.findOne(id);
	    }
	    @Override
	    public long count() {
	        return commentRepository.count();
	    }

	    @Override
	    public void save(Comment contact) {
	    	commentRepository.save(contact);
	    }

	    @Override
	    public void delete(int id) {
	    	commentRepository.delete(id);
	    }
	    
}
