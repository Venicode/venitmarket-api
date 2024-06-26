package com.venimarket.api.controllers;

import com.venimarket.api.services.CustomerService;
import com.venimarket.api.domains.Customer;
import com.venimarket.api.dtos.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDto customerDto) throws Exception{
        Customer newCustomer = this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid CustomerDto customerDto, @PathVariable Long id) throws Exception{
        Customer newCustomer = this.customerService.updateCustomer(customerDto, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> disableCustomer(@PathVariable Long id){
        this.customerService.disableCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
