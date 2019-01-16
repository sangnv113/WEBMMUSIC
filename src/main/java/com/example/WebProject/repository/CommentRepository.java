
package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WebProject.entity.Comment;


public interface CommentRepository extends CrudRepository<Comment, Integer> {

	public List<Comment> findCommentsByNote(int note);
	//public List<Comment> findByNoteContaining(int q);
	public long count();
}
