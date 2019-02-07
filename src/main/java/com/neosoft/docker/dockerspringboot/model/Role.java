package com.neosoft.docker.dockerspringboot.model;

import javax.persistence.*;

/**
 * @author mkarki
 */
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    //for hibernate
    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
