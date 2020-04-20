package com.springboot.imp;

import com.springboot.dao.PoetDao;
import com.springboot.service.PoetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PoetImp implements PoetService {
    @Autowired
    private PoetDao poetDao;
}

