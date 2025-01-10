package com.example.swagger.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String code;

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name=name;
    }

    public long getId ( ) {
        return id;
    }

    public void setId ( long id ) {
        this.id=id;
    }

    public String getCode ( ) {
        return code;
    }

    public void setCode ( String code ) {
        this.code=code;
    }


}
