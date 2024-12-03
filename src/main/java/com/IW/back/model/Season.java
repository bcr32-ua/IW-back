package com.IW.back.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

@Data
@Entity
@Table(name = "season")
public class Season implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "season_start")
    private Date season_start;

    @Column(name = "season_end")
    private Date season_end;

    @Column(name = "multiplier")
    private double multiplier;
}
