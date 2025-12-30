package edu.icet.service;

import edu.icet.model.dto.customer.CustomerRequestDto;
import edu.icet.model.dto.customer.CustomerResponseDto;
import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerRequestDto dto);
    CustomerResponseDto login(String email, String password);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto getCustomerById(Integer id);
    void deleteCustomer(Integer id);
}