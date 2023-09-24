package com.petcare.petcare.pet.model.dto;
import com.petcare.petcare.pet.enums.PetBreed;
import com.petcare.petcare.pet.enums.PetType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.lang.NonNull;

@Data
@Builder
public class PetSeed {
    @NonNull
    @Size(min = 2)
    private String name;
    @NotNull
    private PetType petType;
    @NonNull
    private PetBreed petBreed;
    @Email
    private String ownerEmail;


}
