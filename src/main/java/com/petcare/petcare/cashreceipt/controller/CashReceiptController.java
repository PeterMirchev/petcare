package com.petcare.petcare.cashreceipt.controller;
import com.petcare.petcare.cashreceipt.service.CashReceiptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@RestController()
@RequestMapping("cash-receipt")
public class CashReceiptController {
    private final CashReceiptService cashReceiptService;

    public CashReceiptController(CashReceiptService cashReceiptService) {
        this.cashReceiptService = cashReceiptService;
    }

    @PostMapping
    public CashReceiptExpose create(@Valid @RequestBody CashReceiptSeed cashReceiptSeed) {
        return cashReceiptService.create(cashReceiptSeed);
    }

    
    @GetMapping("/count")
    public Long count() {
        return cashReceiptService.count();
    }

    @GetMapping("/{id}")
    public CashReceiptExpose findById(@PathVariable("id") UUID id) {
        return cashReceiptService.findById(id);

    }

    @GetMapping()
    public Collection<CashReceiptExpose> findAll() {
        return cashReceiptService.findAll();
    }

    @GetMapping("/all-paid")
    public List<CashReceiptExpose> findAllPaid() {
        return cashReceiptService.findAllPaid();
    }

    @GetMapping("/all-not-paid")
    public List<CashReceiptExpose> findAllNotPaid() {
        return cashReceiptService.findAllNotPaid();
    }

    @PutMapping("/{id}")
    public CashReceiptExpose pay(@PathVariable("id") UUID id) {
        cashReceiptService.pay(id);
        return cashReceiptService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
        cashReceiptService.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted cash receipt.");
    }

}
