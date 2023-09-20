package com.petcare.petcare.cashreceipt.service.impl;
import com.petcare.petcare.cashreceipt.ExceptionMessages;
import com.petcare.petcare.NonExistingEntityException;
import com.petcare.petcare.cashreceipt.repository.CashReceiptRepository;
import com.petcare.petcare.cashreceipt.controller.CashReceiptExpose;
import com.petcare.petcare.cashreceipt.controller.CashReceiptSeed;
import com.petcare.petcare.cashreceipt.service.CashReceiptService;
import com.petcare.petcare.cashreceipt.model.CashReceipt;
import com.petcare.petcare.cashreceipt.utilities.CashReceiptMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class CashReceiptImpl implements CashReceiptService {

     private final CashReceiptRepository cashReceiptRepository;

    public CashReceiptImpl(CashReceiptRepository cashReceiptRepository) {
        this.cashReceiptRepository = cashReceiptRepository;
    }

    @Override
    public Long count() {
        return cashReceiptRepository.count();
    }

    @Override
    public CashReceiptExpose create(CashReceiptSeed cashReceiptSeed) {
        CashReceipt cashReceipt = CashReceiptMapper.toCashReceipt(cashReceiptSeed);
        cashReceipt.setDeleted(false);
        cashReceipt.setPaid(false);
        cashReceiptRepository.save(cashReceipt);
        return CashReceiptMapper.toCashReceiptExpose(cashReceipt);
    }

    @Override
    public CashReceiptExpose findById(UUID id){
        CashReceipt cashReceipt = cashReceiptRepository.findById(id)
                .orElseThrow(()-> new NonExistingEntityException(String.format(ExceptionMessages.CASH_RECEIPT_DOES_NOT_EXIST, id)));
        return CashReceiptMapper.toCashReceiptExpose(cashReceipt);
    }

    @Override
    public Collection<CashReceiptExpose> findAll() {
        return cashReceiptRepository
                .findAll()
                .stream()
                .map(CashReceiptMapper::toCashReceiptExpose)
                .toList();

    }

    public List<CashReceiptExpose> findAllPaid() {
        return cashReceiptRepository
                .findAllPaid()
                .stream()
                .map(CashReceiptMapper::toCashReceiptExpose)
                .toList();
    }

    @Override
    public List<CashReceiptExpose> findAllNotPaid() {
        return cashReceiptRepository
                .findAllNotPaid()
                .stream()
                .map(CashReceiptMapper::toCashReceiptExpose)
                .toList();
    }

    @Transactional
    public void pay(UUID id) {
        cashReceiptRepository.pay(id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        cashReceiptRepository.setDeleteStatus(id, true);
    }

}
