package com.petcare.petcare.cashreceipt.utilities;

import com.petcare.petcare.cashreceipt.controller.CashReceiptExpose;
import com.petcare.petcare.cashreceipt.controller.CashReceiptSeed;
import com.petcare.petcare.cashreceipt.model.CashReceipt;

import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;


@UtilityClass
public class CashReceiptMapper {
    public static CashReceiptExpose toCashReceiptExpose(CashReceipt cashReceipt) {

        return CashReceiptExpose.builder()
                .id(cashReceipt.getId())
                .description(cashReceipt.getDescription())
                .doctorName(cashReceipt.getDoctorName())
                .createdOn(cashReceipt.getCreatedOn())
                .price(cashReceipt.getPrice())
                .isDeleted(cashReceipt.isDeleted())
                .isPaid(cashReceipt.isPaid())
                .build();
    }


    public static CashReceipt toCashReceipt(CashReceiptSeed cashReceiptSeed) {
        return CashReceipt.builder()
                .createdOn(OffsetDateTime.now())
                .doctorName(cashReceiptSeed.getDoctorName())
                .description(cashReceiptSeed.getDescription())
                .price(cashReceiptSeed.getPrice())
                .build();
    }
}
