package com.thesis.accounts_microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "E-mail cannot be a null or empty")
    @Email(message = "Entered email is invalid.")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{9})", message = "Entered phone number is invalid. Must have 9 digits.")
    private String mobileNumber;

    private AccountsDTO accountsDTO;
}
