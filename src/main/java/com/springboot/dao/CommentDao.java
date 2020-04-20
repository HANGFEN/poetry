package com.springboot.dao;

import com.springboot.entity.TComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<TComment, Long> {
}
