package com.petcare.petcare.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "pet_owner")
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



