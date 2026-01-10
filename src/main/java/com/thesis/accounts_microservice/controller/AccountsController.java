package com.thesis.accounts_microservice.controller;

import com.thesis.accounts_microservice.constants.AccountsConstants;
import com.thesis.accounts_microservice.dto.AccountsDTO;
import com.thesis.accounts_microservice.dto.CustomerDTO;
import com.thesis.accounts_microservice.dto.ResponseDTO;
import com.thesis.accounts_microservice.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private final IAccountsService iAccountsService;
    private IAccountsService accountsService;

    @PostMapping(path = "/create-account")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {

        accountsService.createAccount(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch-customer")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobilePhone) {
        CustomerDTO customerDTO = accountsService.fetchAccount(mobilePhone);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDTO);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<ResponseDTO> updateAccount(@RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = iAccountsService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
