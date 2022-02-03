package com.example.maddennflbet.service;


import com.example.maddennflbet.model.Team;
import com.example.maddennflbet.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getCategories() {
        System.out.println("service calling getCategories ==>");
        return teamRepository.findAll();
    }

    public Optional getCategory(Long categoryId) {
        System.out.println("service getCategory ==>");
        Optional category = teamRepository.findById(team_Id);
        if (category.isPresent()) {
            return team;
        } else {
            throw new InformationNotFoundException("category with id " + team_Id + " not found");
        }
    }

    public Team createCategory(Team teamObject) {
        System.out.println("service calling createCategory ==>");

        Team team = teamRepository.findById(teamObject.getName());
        if (team != null) {
            throw new InformationExistException("category with name " + team.getName() + " already exists");
        } else {
            return teamRepository.save(teamObject);
        }
    }

    public Team updateCategory(Long teamId, Team teamObject) {
        System.out.println("service calling updateCategory ==>");
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            if (teamObject.getName().equals(team.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("team " + team.get().getName() + " is already exists");
            } else {
                Team updateCategory = teamRepository.findById(teamId).get();
                updateCategory.setName(teamObject.getName());
                updateCategory.setDescription(teamObject.getDescription());
                return teamRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Optional<Team> deleteCategory(Long team_Id) {
        System.out.println("service calling deleteCategory ==>");
        Optional<Team> team = teamRepository.findById(team_Id);

        if (((Optional<?>) team).isPresent()) {
            teamRepository.deleteById(team_Id);
            return team;
        } else {
            throw new InformationNotFoundException("team with id " + team_Id + " not found");
        }
    }
}

