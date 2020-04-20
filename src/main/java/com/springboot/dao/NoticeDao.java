package com.springboot.dao;

import com.springboot.entity.TNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeDao extends JpaRepository<TNotice,Long> {
}
