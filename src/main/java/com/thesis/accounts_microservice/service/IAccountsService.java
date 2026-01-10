package com.thesis.accounts_microservice.service;

import com.thesis.accounts_microservice.dto.CustomerDTO;

public interface IAccountsService {
    /**
     *
     * @param customerDTO CustomerDTO that will be converted to regular Entity and created in database
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobilePhone param which will be used to find Customer into database
     * @return customerDTO result
     */
    CustomerDTO fetchAccount(String mobilePhone);

    boolean updateAccount(CustomerDTO customerDTO);
}
