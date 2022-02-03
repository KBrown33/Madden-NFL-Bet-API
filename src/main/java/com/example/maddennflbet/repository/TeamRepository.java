package com.example.maddennflbet.repository;


import com.example.maddennflbet.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByUser_Id(Long teamId);
}
