package com.example.bankservice.repository;

import com.example.bankservice.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
    boolean existsByOrgId(String orgId);
    boolean existsByTin(String tin);
    boolean existsByRoutingNumber(String routingNumber);
    boolean existsByLei(String lei);
}