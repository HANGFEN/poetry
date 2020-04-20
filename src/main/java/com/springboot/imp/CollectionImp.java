package com.springboot.imp;

import com.springboot.dao.CollectionDao;
import com.springboot.dao.UserDao;
import com.springboot.entity.TCollection;
import com.springboot.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CollectionImp implements CollectionService {
    @Autowired
    private CollectionDao collectionDao;
    @Override
    public void addCollection(TCollection colleciton) {
    collectionDao.save(colleciton);
    }
}
