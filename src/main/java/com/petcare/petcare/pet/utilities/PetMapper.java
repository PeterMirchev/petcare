package com.petcare.petcare.pet.utilities;
import com.petcare.petcare.pet.enums.PetType;
import com.petcare.petcare.pet.model.dto.PetExpose;
import com.petcare.petcare.pet.model.Pet;
import com.petcare.petcare.pet.model.dto.PetSeed;
import com.petcare.petcare.petowner.model.PetOwner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetMapper {

    public static Pet toPet (PetSeed petSeed, PetOwner petOwner) {
        return Pet.builder()
                .name(petSeed.getName())
                .petType(petSeed.getPetType())
                .petBreed(petSeed.getPetBreed())
                .petOwner(petOwner)
                .build();
    }

    public static PetExpose toPetExpose(Pet pet) {
        return PetExpose.builder()
                .id(pet.getId())
                .name(pet.getName())
                .petOwnerFirstName(pet.getPetOwner().getFirstName())
                .petOwnerLastName(pet.getPetOwner().getLastName())
                .petOwnerEmail(pet.getPetOwner().getEmail())
                .petOwnerId(String.valueOf(pet.getPetOwner().getId()))
                .petType(pet.getPetType())
                .cashReceipList(pet.getCashReceipList())
                .build();
    }
}
