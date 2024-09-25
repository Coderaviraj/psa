package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "kyc")
public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "aadhar", nullable = false, unique = true)
    private String aadhar;

    @Column(name = "pan", nullable = false, unique = true, length = 10)
    private String pan;

    @OneToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;  // This should reference the Customer entity correctly

    // Constructor, getters, and setters are handled by Lombok annotations
}