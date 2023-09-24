package com.petcare.petcare.petowner.service;

import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public interface PetOwnerService {

    long count();

    PetOwnerExpose findById(UUID id);

    PetOwner findPetOwnerByEmail(String email);

    PetOwnerExpose findByFirstNameAndLastName(String firstName, String lastName);

    Collection<PetOwnerExpose> findAll();

    PetOwnerExpose create(PetOwnerSeed petOwnerSeed);

    PetOwnerExpose addPetByEmail(String petOwnerEmail, String petId);

    void deleteById(UUID id);




}
