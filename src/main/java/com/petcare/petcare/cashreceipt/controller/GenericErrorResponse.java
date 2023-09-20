package com.petcare.petcare.cashreceipt.controller;

import lombok.Builder;

@Builder
public record GenericErrorResponse(
        String exceptionName,
        String exceptionMessage
) {
}
