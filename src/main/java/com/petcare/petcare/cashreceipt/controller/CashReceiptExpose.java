package com.petcare.petcare.cashreceipt.controller;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@Builder
public class CashReceiptExpose {
    private Long id;
    private BigDecimal price;
    private String doctorName;
    private String description;
    private OffsetDateTime createdOn;
    private boolean isDeleted;
    private boolean isPaid;
}
