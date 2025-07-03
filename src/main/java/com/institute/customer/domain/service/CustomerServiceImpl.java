package com.institute.customer.domain.service;

import com.institute.customer.domain.model.Customer;
import com.institute.customer.domain.model.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String uid) {
        return customerRepository.findById(uid);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(String uid, Customer customer) {
        return customerRepository.update(uid, customer);
    }

    @Override
    public void deleteById(String uid) {
        customerRepository.deleteById(uid);
    }
}
