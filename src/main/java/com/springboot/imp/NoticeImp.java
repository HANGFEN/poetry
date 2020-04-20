package com.springboot.imp;

import com.springboot.dao.NoticeDao;
import com.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NoticeImp implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
}
