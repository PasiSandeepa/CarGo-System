package edu.icet.service.impl;

import edu.icet.entity.Customer;
import edu.icet.model.dto.customer.CustomerRequestDto;
import edu.icet.model.dto.customer.CustomerResponseDto;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerRequestDto dto) {

        Customer customer = modelMapper.map(dto, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public CustomerResponseDto login(String email, String password) {

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (customer.getPassword().equals(password)) {
            return modelMapper.map(customer, CustomerResponseDto.class);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }
}