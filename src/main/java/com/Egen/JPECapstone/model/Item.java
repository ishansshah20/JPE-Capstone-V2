package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@Data
public class Item {

    @Id
    private String id;
    private String name;

    public Item(){
        this.id = UUID.randomUUID().toString();
    }
}
