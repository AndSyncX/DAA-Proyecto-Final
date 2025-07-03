package com.institute.customer.domain.service;

import com.institute.customer.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(String uid);
    Customer save(Customer customer);
    Customer update(String uid, Customer customer);
    void deleteById(String uid);
}
