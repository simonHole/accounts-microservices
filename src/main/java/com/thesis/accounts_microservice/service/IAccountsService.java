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

    /**
     *
     * @param customerDTO CustomerDTO that should be modified
     * @return result of operation (true if modify is successfully or false if something went wrong
     */
    boolean updateAccount(CustomerDTO customerDTO);


    /**
     *
     * @param mobilePhone CustomerDTO that should be removed
     * @return result of operation (true if customer and account has been deleted successfully or false if something went wrong
     */
    boolean deleteAccount(String mobilePhone);
}
