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


    public MaddenNFL getMaddenNFL() {
        return maddenNFL;
    }

    public void setMaddenNfl(MaddenNFL maddenNfl){

        this.maddenNFL = maddenNFL;
    }

    @ManyToOne
    @JoinColumn(name ="bet_id")
    @JsonIgnore
    private MaddenNFL maddenNFL;

    public Winner() {

    }

    public void setMaddenNFL(MaddenNFL maddenNFL) {
        this.maddenNFL = maddenNFL;
    }

    public Long getId() {
        return id;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Winner(Long id, Integer bet, Integer winner) {
        this.id = id ;
        this.bet = bet;
        this.winner = winner;
    }

}
