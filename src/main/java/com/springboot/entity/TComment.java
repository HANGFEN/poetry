package com.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_Comment", schema = "test")
public class TComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;//自增
    private Date time;//发表时间
    private String email;//评论者邮箱
    private String comment;//评论内容
    private int poetryid;//诗词类id

    public TComment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPoetryid() {
        return poetryid;
    }

    public void setPoetryid(int poetryid) {
        this.poetryid = poetryid;
    }
}
