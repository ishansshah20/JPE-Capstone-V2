package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Customer(){
        this.id = UUID.randomUUID().toString();
    }
}
