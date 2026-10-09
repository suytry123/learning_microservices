package com.school.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.account.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
