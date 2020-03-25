package com.example.poetry.domain;

import java.io.Serializable;


import javax.persistence.*;

@Entity
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Uid;
}