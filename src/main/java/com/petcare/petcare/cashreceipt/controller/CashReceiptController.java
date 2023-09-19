package com.petcare.petcare.cashreceipt.controller;
import com.petcare.petcare.cashreceipt.service.CashReceiptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;


@RestController()
@RequestMapping("cash-receipt")
public class CashReceiptController {
    private final CashReceiptService cashReceiptService;

    public CashReceiptController(CashReceiptService cashReceiptService) {
        this.cashReceiptService = cashReceiptService;
    }

    @PostMapping("/create")
    public CashReceiptExpose create(@Valid @RequestBody CashReceiptSeed cashReceiptSeed) {
        return cashReceiptService.create(cashReceiptSeed);
    }

    
    @GetMapping("/count")
    public Long count() {
        return cashReceiptService.count();
    }

    @GetMapping("/{id:\\d+}")
    public CashReceiptExpose findById(@PathVariable("id") Long id) {
        return cashReceiptService.findById(id);

    }

    @GetMapping()
    public Collection<CashReceiptExpose> findAll() {
        return cashReceiptService.findAll();
    }

    @GetMapping("/AllPaid")
    public List<CashReceiptExpose> findAllPaid() {
        return cashReceiptService.findAllPaid();
    }

    @PutMapping("/{id:\\d+}")
    public CashReceiptExpose pay(@PathVariable("id") Long id) {
        cashReceiptService.pay(id);
        return cashReceiptService.findById(id);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        cashReceiptService.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted cash receipt.");
    }
}
