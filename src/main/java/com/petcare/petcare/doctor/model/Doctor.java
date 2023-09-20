package com.petcare.petcare.doctor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    @Size(min = 2)
    private String firstName;
    @NonNull
    @Size(min = 2)
    private String lastName;


}
