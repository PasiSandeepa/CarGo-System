package edu.icet.controller;


import edu.icet.model.dto.customer.CustomerRequestDto;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerRequestDto dto) {
        customerService.addCustomer(dto);
        return ResponseEntity.ok("Customer Registered Successfully");
    }

}
