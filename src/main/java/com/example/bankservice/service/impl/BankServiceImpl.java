package com.example.bankservice.service.impl;

import com.example.bankservice.exception.BusinessException;
import com.example.bankservice.model.Bank;
import com.example.bankservice.repository.BankRepository;
import com.example.bankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (bankRepository.existsByOrgId(bank.getOrgId())) {
            throw new BusinessException("business_validation", "uniqueness_constraints", "bank already exists with this org id");
        }

        if (bankRepository.existsByTin(bank.getTin())) {
            throw new BusinessException("business_validation", "uniqueness_constraints", "bank already exists with this tin");
        }

        if (bankRepository.existsByRoutingNumber(bank.getRoutingNumber())) {
            throw new BusinessException("business_validation", "uniqueness_constraints", "bank already exists with this routing number");
        }

        if (bankRepository.existsByLei(bank.getLei())) {
            throw new BusinessException("business_validation", "uniqueness_constraints", "bank already exists with this lei");
        }

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