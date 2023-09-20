package com.petcare.petcare.petowner.utilities;

import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import lombok.experimental.UtilityClass;

import java.util.HashSet;

@UtilityClass
public class PetOwnerMapper {

    public static PetOwner toPetOwner (PetOwnerSeed petOwnerSeed) {
        return PetOwner.builder()
                .firstName(petOwnerSeed.getFirstName())
                .lastName(petOwnerSeed.getLastName())
                .email(petOwnerSeed.getEmail())
                .pets(new HashSet<>())
                .build();
    }

    public static PetOwnerExpose toPetOwnerExpose(PetOwner petOwner) {
        return PetOwnerExpose.builder()
                .id(petOwner.getId())
                .firstName(petOwner.getFirstName())
                .lastName(petOwner.getLastName())
                .email(petOwner.getEmail())
                .pets(petOwner.getPets())
                .build();
    }
}
