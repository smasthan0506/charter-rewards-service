package com.charter.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.charter.rewards.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
