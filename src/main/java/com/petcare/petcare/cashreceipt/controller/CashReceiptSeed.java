package com.petcare.petcare.cashreceipt.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CashReceiptSeed {
    @NonNull
    @Min(1)
    private BigDecimal price;
    @NonNull

    private String doctorName;
    @NonNull
    @Size(min = 2, message = "Invalid Description Size - must be greater than or equals to 2 symbols.")
    private String description;
    private OffsetDateTime createdOn;

}
