package com.Egen.JPECapstone.repository;

import com.Egen.JPECapstone.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
