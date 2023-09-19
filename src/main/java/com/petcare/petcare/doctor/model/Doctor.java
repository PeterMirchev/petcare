package com.petcare.petcare.doctor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Size(min = 2)
    private String firstName;
    @NonNull
    @Size(min = 2)
    private String lastName;


}
