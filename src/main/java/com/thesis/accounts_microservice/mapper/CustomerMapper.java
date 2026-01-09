package com.thesis.accounts_microservice.mapper;

import com.thesis.accounts_microservice.dto.CustomerDTO;
import com.thesis.accounts_microservice.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO mapTocustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }
}
