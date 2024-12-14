package com.IW.back.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

@Data
@Entity
@Table(name = "booking")
public class Booking implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany
    @JoinTable(
        name = "booking_service",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "total_price")
    private double total_price;

    @Column(name = "notes")
    private String notes;

}

