package edu.icet.controller;


import edu.icet.model.dto.customer.CustomerRequestDto;
import edu.icet.model.dto.customer.CustomerResponseDto;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerRequestDto dto) {
        customerService.addCustomer(dto);
        return ResponseEntity.ok("Customer Registered Successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerRequestDto dto) {
        try {
            CustomerResponseDto response = customerService.login(dto.getEmail(), dto.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @GetMapping("/get-all")
    public List<CustomerResponseDto> getAll() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer id) {
        CustomerResponseDto customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer Deleted Successfully");
    }
}

