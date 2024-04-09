package com.example.bankservice.model;

import com.example.bankservice.annotation.Fixed;
import com.example.bankservice.annotation.RoutingNumber;
import com.example.bankservice.annotation.USPhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    @Column(name = "lei")
    private String lei;

    @RoutingNumber
    @Column(name = "routing_number")
    private String routingNumber;

    @USPhoneNumber
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty
    @Column(name = "email")
    private String email;
}