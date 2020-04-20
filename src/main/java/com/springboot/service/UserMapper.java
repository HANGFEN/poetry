package com.springboot.service;

import com.springboot.entity.TUser;

import java.util.List;

public interface UserMapper {
    List<TUser> getUser();
    void registerUser(TUser tUser);
    TUser getTuser(TUser tuser);
}
