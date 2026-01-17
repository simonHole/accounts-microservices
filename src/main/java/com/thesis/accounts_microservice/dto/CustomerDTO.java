package com.thesis.accounts_microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDTO implements Serializable {
    @Schema(
            description = "Name of the customer", example = "Simon"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "E-mail address of customer", example = "johndoe@yahoo.com"
    )
    @NotEmpty(message = "E-mail cannot be a null or empty")
    @Email(message = "Entered email is invalid.")
    private String email;

    @Schema(
            description = "Mobile phone number of customer", example = "500100500"
    )
    @Pattern(regexp = "(^$|[0-9]{9})", message = "Entered phone number is invalid. Must have 9 digits.")
    private String mobileNumber;

    @Schema(
            description = "Accounts details of the Customer"
    )
    private AccountsDTO accountsDTO;
}
