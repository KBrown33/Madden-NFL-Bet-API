package com.example.maddennflbet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "winners" )
public class Winner {



    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer bet;

    @Column
    private Integer winner;


    public MaddenNFL getMaddenNfl() {
        return maddenNfl;
    }

    public void setMaddenNfl(MaddenNfl maddenNfl){
        this.maddenNfl = maddenNfl;
    }

    @ManyToOne
    @JoinColumn(name =)
    @JsonIgnore
    private

}
