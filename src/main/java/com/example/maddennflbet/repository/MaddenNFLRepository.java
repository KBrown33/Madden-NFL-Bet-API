package com.example.maddennflbet.repository;

import com.example.maddennflbet.model.MaddenNFL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaddenNFLRepository extends JpaRepository<MaddenNFL, Long> {
    MaddenNFL find(Integer )
}
