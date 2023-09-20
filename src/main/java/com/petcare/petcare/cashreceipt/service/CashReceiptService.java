package com.petcare.petcare.cashreceipt.service;
import com.petcare.petcare.cashreceipt.controller.CashReceiptExpose;
import com.petcare.petcare.cashreceipt.controller.CashReceiptSeed;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface CashReceiptService {
    Long count();
    CashReceiptExpose create(CashReceiptSeed cashReceiptSeed);
    CashReceiptExpose findById(UUID id);
    Collection<CashReceiptExpose> findAll();

    void deleteById(UUID id);

    List<CashReceiptExpose> findAllPaid();

    List<CashReceiptExpose> findAllNotPaid();

    void pay(UUID id);

}
