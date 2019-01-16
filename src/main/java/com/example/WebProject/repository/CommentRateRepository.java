
package com.example.WebProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.WebProject.entity.CommentRate;
import com.example.WebProject.entity.CommentRateIndentity;


public interface CommentRateRepository extends CrudRepository<CommentRate, CommentRateIndentity> {
}
