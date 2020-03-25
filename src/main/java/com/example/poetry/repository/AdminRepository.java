package com.example.poetry.repository;

import com.example.poetry.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  AdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

}








