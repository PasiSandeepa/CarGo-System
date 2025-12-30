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
                .orElseThrow(() -> new RuntimeException("Email address not found!"));

        String dbPassword = customer.getPassword().trim();
        String inputPassword = password.trim();

        if (dbPassword.equals(inputPassword)) {

            CustomerResponseDto response = new CustomerResponseDto();


            response.setCustomerid(customer.getCustomerId());

            response.setFirstName(customer.getFirstName());
            response.setLastName(customer.getLastName());
            response.setEmail(customer.getEmail());
            response.setNic(customer.getNic());
            response.setPhoneNumber(customer.getPhoneNumber());
            response.setAddress(customer.getAddress());

            return response;
        } else {
            throw new RuntimeException("Password incorrect!");
        }
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto getCustomerById(Integer id) {

        Customer customer = customerRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));


        return modelMapper.map(customer, CustomerResponseDto.class);
    }
    @Override
    public void deleteCustomer(Integer id) {
        if (customerRepository.existsById(Long.valueOf(id))) {
            customerRepository.deleteById(Long.valueOf(id));
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }
}