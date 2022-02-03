package com.example.maddennflbet.service;


import com.example.maddennflbet.model.Winner;
import com.example.maddennflbet.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WinnerService {
    private WinnerRepository winnerRepository;

    @Autowired
    public void setWinnerRepository(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    public List<Winner> getCategories() {
        System.out.println("service calling getCategories ==>");
        return winnerRepository.findAll();
    }

    public Optional getCategory(Long categoryId) {
        System.out.println("service getCategory ==>");
        Optional winner = winnerRepository.findById(winnerId);
        if (winner.isPresent()) {
            return winner;
        } else {
            throw new InformationNotFoundException("winner with id " + winnerId + " not found");
        }
    }

    public Winner createCategory(Winner winnerObject) {
        System.out.println("service calling createCategory ==>");

        Winner winner = winnerRepository.findByName(winnerObject.getName());
        if (winner != null) {
            throw new InformationExistException("winner with name " + winner.getName() + " already exists");
        } else {
            return winnerRepository.save(winnerObject);
        }
    }

    public Winner updateCategory(Long winnerId, Winner winnerObject) {
        System.out.println("service calling updateCategory ==>");
        Optional<Winner> category = winnerRepository.findById(winnerId);
        if (category.isPresent()) {
            if (winnerObject.getName().equals(winner.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("winner" + winner.get().getName() + " is already exists");
            } else {
                Winner updateCategory = winnerRepository.findById(winnerId).get();
                updateCategory.setName(winnerObject.getName());
                updateCategory.setDescription(winnerObject.getDescription());
                return winnerRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("winner with id " + winnerId + " not found");
        }
    }

    public Optional<Winner> deleteCategory(Long winnerId) {
        System.out.println("service calling deleteCategory ==>");
        Optional<Winner> category = winnerRepository.findById(winnerId);

        if (((Optional<?>) category).isPresent()) {
            winnerRepository.deleteById(winnerId);
            return winner;
        } else {
            throw new InformationNotFoundException("winner with id " + winnerId + " not found");
        }
    }
}

