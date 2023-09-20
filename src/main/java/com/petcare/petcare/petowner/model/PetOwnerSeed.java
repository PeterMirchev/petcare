package com.petcare.petcare.petowner.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class PetOwnerSeed {
    @NonNull
    @Size(min = 2)
    private String firstName;
    @NonNull
    @Size(min = 2)
    private String lastName;
    @NonNull
    @Email
    private String email;

}
