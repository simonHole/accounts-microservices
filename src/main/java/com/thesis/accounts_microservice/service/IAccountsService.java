package com.thesis.accounts_microservice.service;

import com.thesis.accounts_microservice.dto.CustomerDTO;

public interface IAccountsService {
    /**
     *
     * @param customerDTO CustomerDTO Object
     */
    void createAccount(CustomerDTO customerDTO);
}
