package com.petcare.petcare.pet.model.dto.seed;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class PetSeed {
    @NonNull
    private String name;
    @NotNull
    private String petType;


}
