package com.petcare.petcare.cashreceipt.controller;

import lombok.Builder;

@Builder
public record GenericErrorResponseInvalidInput(
        String exceptionName,
        String exceptionMessage,
        String requiredType

) {
}
