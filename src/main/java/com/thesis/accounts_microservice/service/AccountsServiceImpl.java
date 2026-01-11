package com.thesis.accounts_microservice.service;

import com.thesis.accounts_microservice.constants.AccountsConstants;
import com.thesis.accounts_microservice.dto.AccountsDTO;
import com.thesis.accounts_microservice.dto.CustomerDTO;
import com.thesis.accounts_microservice.entity.Accounts;
import com.thesis.accounts_microservice.entity.Customer;
import com.thesis.accounts_microservice.exception.CustomerAlreadyExistsException;
import com.thesis.accounts_microservice.exception.ResourceNotFoundException;
import com.thesis.accounts_microservice.mapper.AccountsMapper;
import com.thesis.accounts_microservice.mapper.CustomerMapper;
import com.thesis.accounts_microservice.repository.AccountsRepository;
import com.thesis.accounts_microservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    // Autowiring will be done automatically because there is only one constructor with all params, and Spring take care of autowiring these dependencies.
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customer.getMobileNumber() + " already exists");
        }

        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDTO fetchAccount(String mobilePhone) {
        Customer customer = customerRepository.findByMobileNumber(mobilePhone)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobilePhone", mobilePhone));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDTO customerDTO = CustomerMapper.mapTocustomerDTO(customer, new CustomerDTO());
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDTO(accounts, new AccountsDTO()));
        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountsDTO accountsDTO = customerDTO.getAccountsDTO();
        if (accountsDTO != null) {
            Accounts accounts = accountsRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "accountNumber", accountsDTO.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccountEntity(accountsDTO, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer  = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobilePhone) {
        Customer customerToDelete = customerRepository.findByMobileNumber(mobilePhone).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobilePhone", mobilePhone)
        );
        accountsRepository.deleteByCustomerId(customerToDelete.getCustomerId());
        customerRepository.deleteById(customerToDelete.getCustomerId());
        return true;
    }


    /**
     *
     * @param customer Customer Object
     * @return new Account Details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
