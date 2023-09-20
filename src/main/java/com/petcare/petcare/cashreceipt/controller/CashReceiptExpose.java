package com.petcare.petcare.cashreceipt.controller;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class CashReceiptExpose {
    private UUID id;
    private BigDecimal price;
    private String doctorName;
    private String description;
    private OffsetDateTime createdOn;
    private boolean isDeleted;
    private boolean isPaid;
}
