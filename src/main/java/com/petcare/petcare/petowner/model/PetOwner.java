package com.petcare.petcare.petowner.model;
import com.petcare.petcare.pet.model.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "pet_owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Size(min= 2)
    @NonNull
    private String firstName;
    @Size(min= 2)
    @NonNull
    private String lastName;
    @Email
    @NonNull
    @Column(unique = true)
    private String email;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Pet> pets = new HashSet<>();

}



