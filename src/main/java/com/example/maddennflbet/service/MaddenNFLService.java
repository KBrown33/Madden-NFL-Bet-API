package com.example.maddennflbet.service;


import com.example.maddennflbet.model.MaddenNFL;
import com.example.maddennflbet.repository.MaddenNFLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaddenNFLService {
    private MaddenNFLRepository maddenNFLRepository;

    @Autowired
    public void setCategoryRepository(MaddenNFLRepository maddenNFLRepository) {
        this.maddenNFLRepository = maddenNFLRepository;
    }

    public List<MaddenNFL> getUsers() {
        return MaddenNFLRepository.findAll();
    }

    public Optional geMaddenNFL(Long maddenNFLId) {
        System.out.println("service getCategory ==>");
        Optional category = maddenNFLRepository.findById(maddenNFLId);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("maddenNFL with id " + maddenNFLId + " not found");
        }
    }

    public MaddenNFL createMaddenNFL(MaddenNFL maddenNFLObject) {
        System.out.println("service calling createMaddenNFL ==>");

        MaddenNFL maddenNFL = maddenNFLRepository.findByName(maddenNFLObject.getName());
        if (maddenNFL != null) {
            throw new InformationExistException("category with name " + maddenNFL.getName() + " already exists");
        } else {
            return maddenNFLRepository.save(maddenNFLObject);
        }
    }

    public MaddenNFL updateCategory(Long maddenNFLId, MaddenNFL maddenNFLObject) {
        System.out.println("service calling updateCategory ==>");
        Optional<MaddenNFL> maddenNFL = maddenNFLRepository.findById(maddenNFLId);
        if (maddenNFL.isPresent()) {
            if (maddenNFLObject.getName().equals(maddenNFL.get().getName()) {
                System.out.println("Same");
                throw new InformationExistException("category " + maddenNFL.get().getName() + " is already exists");
            } else {
                MaddenNFL updateCategory = maddenNFLRepository.findById(maddenNFLId).get();
                updateCategory.setName(maddenNFLObject.getName());
                updateCategory.setDescription(maddenNFLObject.getDescription());
                return maddenNFLRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("category with id " + maddenNFLId + " not found");
        }
    }

    public Optional<MaddenNFL> deleteCategory(Long maddenNFLId) {
        System.out.println("service calling deleteCategory ==>");
        Optional<MaddenNFL> category = maddenNFLRepository.findById(maddenNFLId);

        if (((Optional<?>) category).isPresent()) {
            MaddenNFLRepository.deleteById(maddenNFLId);
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + maddenNFLId + " not found");
        }
    }
}

