package com.thesis.accounts_microservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
