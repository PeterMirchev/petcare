package com.petcare.petcare.petowner;

import com.petcare.petcare.pet.model.entity.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "pet_owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min= 2)
    @NonNull
    private String firstName;
    @Size(min= 2)
    @NonNull
    private String lastName;
    @Email
    @NonNull
    private String email;
    @OneToMany
    private Set<Pet> pets;

}



