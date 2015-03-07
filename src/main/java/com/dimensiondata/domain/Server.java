package com.dimensiondata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Server {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    protected Server() {
        // Required by JPA spec
    }

    public Server(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
