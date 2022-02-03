package com.example.maddennflbet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaddenNFLRepository extends JpaRepository<MaddenNFL, Long> {
    MaddenNFL findName(String)
}
