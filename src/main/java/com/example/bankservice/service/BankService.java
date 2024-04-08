package com.example.bankservice.service;

import com.example.bankservice.model.Bank;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankService {
    Bank saveBank(Bank bank);
    void deleteBank(String id);
    Optional<Bank> getBank(String id);
    List<Bank> getAllBanks();
}