package com.petcare.petcare.cashreceipt.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "cash_receipts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CashReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private BigDecimal price;
    @Column(name = "doctor_name")
    private String doctorName;
    @NonNull
    @Column
    private String description;
    @Column(name = "date_and_time")
    private OffsetDateTime createdOn;
    private boolean isDeleted;
    private boolean isPaid;

}
