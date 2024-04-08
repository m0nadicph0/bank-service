package com.example.bankservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "tin")
    private String tin;

    @Column(name = "lei")
    private String lei;

    @Column(name = "routing_number")
    private String routingNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;
}