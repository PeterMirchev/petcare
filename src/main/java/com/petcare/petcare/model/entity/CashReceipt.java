package com.petcare.petcare.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cash_receipt")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CashReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Min(1)
    private BigDecimal price;
    @OneToOne
    private Doctor doctor;
    @NonNull
    @Size(min = 2)
    private String description;

}
