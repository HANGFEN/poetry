package com.springboot.service;

import com.springboot.entity.TUser;
import com.springboot.entity.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends java.io.Serializable{
    void addUser(TUser user);
    void modifyUser(TUser user);
    List<TUser> findEmail(String email);
    TUser checkUser(UserLogin user);
    //管理员对用户的操作
    public void save(TUser u)throws Exception;
    public Page<TUser> findAll(String kw, Pageable pageable);
    public TUser findById(long id);
    public void delete(TUser u);//删除一条信息
    public void deleteById(long id);
    public void deletes(List<TUser> users);//批量删除
}


