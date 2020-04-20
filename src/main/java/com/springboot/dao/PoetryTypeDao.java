package com.springboot.dao;

import com.springboot.entity.TPoetryType;
import com.springboot.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface PoetryTypeDao extends JpaRepository<TPoetryType,Long> {



}
