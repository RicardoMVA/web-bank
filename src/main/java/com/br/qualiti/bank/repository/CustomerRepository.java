package com.br.qualiti.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.qualiti.bank.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
