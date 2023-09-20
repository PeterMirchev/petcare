package com.petcare.petcare.petowner.service;

import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface PetOwnerService {

    long count();

    PetOwnerExpose findById(Long id);

    Collection<PetOwnerExpose> findAll();

    PetOwnerExpose create(PetOwnerSeed petOwnerSeed);

    void deleteById(Long id);




}
