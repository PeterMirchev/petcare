package com.petcare.petcare.cashreceipt.service;

import com.petcare.petcare.cashreceipt.controller.CashReceiptExpose;
import com.petcare.petcare.cashreceipt.controller.CashReceiptSeed;


import java.util.Collection;
import java.util.List;

public interface CashReceiptService {
    Long count();
    CashReceiptExpose create(CashReceiptSeed cashReceiptSeed);
    CashReceiptExpose findById(Long id);
    Collection<CashReceiptExpose> findAll();

    void deleteById(Long id);

    List<CashReceiptExpose> findAllPaid();

    void pay(Long id);

}
