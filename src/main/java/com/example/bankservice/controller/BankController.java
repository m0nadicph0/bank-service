package com.example.bankservice.controller;

import com.example.bankservice.model.Bank;
import com.example.bankservice.service.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/banks") // base URI for the controller
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody @Valid Bank bank){
        return ResponseEntity.ok(bankService.saveBank(bank));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable String id){
        return bankService.getBank(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks(){
        return ResponseEntity.ok(bankService.getAllBanks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@RequestBody Bank bank, @PathVariable String id){
        return bankService.getBank(id)
                .map(b -> {
                    bank.setId(id);
                    return ResponseEntity.ok(bankService.saveBank(bank));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable String id){
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content on successful deletion
    }
}