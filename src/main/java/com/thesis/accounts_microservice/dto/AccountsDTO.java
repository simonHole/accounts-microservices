package com.thesis.accounts_microservice.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class AccountsDTO implements Serializable {
    private Long accountNumber;
    private String accountType;
    private String branchAddresses;
}
