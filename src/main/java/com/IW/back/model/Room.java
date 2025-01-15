package com.IW.back.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "room")
public class Room implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "floor")
    private int floor;

    @Column(name = "people")
    private int people;

    @Column(name = "type")
    private String type;

    @Column(name = "base_price")
    private double base_price;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}

