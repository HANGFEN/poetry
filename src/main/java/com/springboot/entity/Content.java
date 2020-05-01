package com.springboot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@Table("tcontent")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @NotNull
    private String title;

    @Lob
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "tid")
//    private ContentType type;




}
