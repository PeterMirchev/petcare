package com.petcare.petcare.cashreceipt.controller;

import lombok.Builder;

@Builder
public record InvalidJsonInput(
   String violatedField,
   String description,
   String rejectedValue
) {
}
