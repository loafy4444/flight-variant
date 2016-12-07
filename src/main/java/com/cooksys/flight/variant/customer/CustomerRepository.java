package com.cooksys.flight.variant.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flight.variant.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findById(Long id);
	
	Customer findByUsername(String username);
}
