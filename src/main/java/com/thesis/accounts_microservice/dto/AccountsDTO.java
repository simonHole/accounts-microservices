package com.thesis.accounts_microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.io.Serializable;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDTO implements Serializable {

    @NotEmpty(message = "AccountNumber cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Entered account number is invalid. Must have 10 digits.")
    @Schema(
            name = "Account number", example = "1000000000",
            description = "Account number of particular account"
    )
    private Long accountNumber;

    @Schema(
            name = "Account Type",
            description = "Type of account"
    )
    @NotEmpty(message = "AccountMessage cannot be null or empty")
    private String accountType;

    @Schema(
            name = "Customer", example = "102/1a 3rd Street",
            description = "Branch address of account"
    )
    @NotEmpty(message = "BranchAddress cannot be null or empty")
    private String branchAddress;
}
