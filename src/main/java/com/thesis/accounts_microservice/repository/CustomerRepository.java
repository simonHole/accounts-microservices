package com.thesis.accounts_microservice.repository;

import com.thesis.accounts_microservice.entity.Customer;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<@NonNull Customer, @NonNull Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
