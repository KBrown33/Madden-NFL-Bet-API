package com.example.maddennflbet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "bets")
public class MaddenNFL {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer user_2;

    @Column
    private Integer money;




    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
}
