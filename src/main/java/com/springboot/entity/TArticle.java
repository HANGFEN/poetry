package com.springboot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarticle")
public class TArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String poem_name;
    private String poetry_name;
    public enum Sex{
        男,女
    };
    private Sex gender;
    private LocalDateTime birthday;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoem_name() {
        return poem_name;
    }

    public void setPoem_name(String poem_name) {
        this.poem_name = poem_name;
    }

    public String getPoetry_name() {
        return poetry_name;
    }

    public void setPoetry_name(String poetry_name) {
        this.poetry_name = poetry_name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
