package com.example.bankservice.service.impl;

import com.example.bankservice.model.Bank;
import com.example.bankservice.repository.BankRepository;
import com.example.bankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository; // Depend on the abstraction, not on the concrete type

    // constructor injection 
    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void deleteBank(String id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Optional<Bank> getBank(String id) {
        return bankRepository.findById(id);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}