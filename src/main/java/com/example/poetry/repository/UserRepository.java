package com.example.poetry.repository;
import  com.example.poetry.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User, String> , JpaSpecificationExecutor<User>{

}







