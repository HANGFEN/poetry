package com.springboot.dao;

import com.springboot.entity.TPoet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoetDao extends JpaRepository<TPoet,Long> {
}
