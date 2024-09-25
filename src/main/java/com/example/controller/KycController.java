package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.Kyc;
import com.example.repository.CustomerRepository;
import com.example.repository.KycRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/kyc")
public class KycController {
    private KycRepository kycRepository;
    private CustomerRepository customerRepository;
    public KycController(KycRepository kycRepository, CustomerRepository customerRepository) {
        this.kycRepository = kycRepository;
        this.customerRepository = customerRepository;
    }


    @PostMapping
    public ResponseEntity<Kyc> createKycLink(@RequestBody Kyc kyc
    ,@RequestParam long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        kyc.setCustomer(customer);
        return ResponseEntity.ok(kycRepository.save(kyc));

    }







}
