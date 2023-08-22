package com.petcare.petcare.model.entity;

import com.petcare.petcare.model.enums.PetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pet")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2)
    @NonNull
    private String name;
    @NonNull
    private PetType petType;
    @NonNull
    @ManyToOne
    private PetOwner petOwner;
    @OneToMany
    private List<CashReceipt> cashReceipList;


}
