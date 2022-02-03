package com.example.maddennflbet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    public Integer getUser_2() {
        return user_2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setUser_2(Integer user_2) {
        this.user_2 = user_2;
    }

    public MaddenNFL() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MaddenNFL(Long id, Integer user_2, Integer money) {
        this.id = id;
        this.user_2 = user_2;
        this.money = money;
    }

    public List<Winner> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<Winner> winnerList) {
        this.winnerList = winnerList;
    }

    @OneToMany(mappedBy = "maddenNFL", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Winner> winnerList;


}
