package com.petcare.petcare.petowner.model;
import com.petcare.petcare.pet.model.Pet;
import lombok.Builder;
import lombok.Data;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class PetOwnerExpose {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Pet> pets;

}
