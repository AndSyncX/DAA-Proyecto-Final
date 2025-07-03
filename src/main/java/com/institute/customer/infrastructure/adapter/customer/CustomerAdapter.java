package com.institute.customer.infrastructure.adapter.customer;

import com.institute.customer.domain.model.Customer;
import com.institute.customer.domain.model.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerAdapter implements CustomerRepository {

    private CustomerDataRepository customerDataRepository;

    @Override
    public List<Customer> findAll() {
        return customerDataRepository.findAll()
                .stream()
                .filter(customerData -> customerData.getActive() != 0)
                .map(CustomerMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    /* public Optional<Customer> findById(String uid) */
    public Customer findById(String uid) {
        /* Consultar sobre optional */
        return customerDataRepository.findById(uid)
                .filter(customerData -> customerData.getActive() == 1)
                .map(CustomerMapper.MAPPER::toModel)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found or inactive: " + uid));

        /* Customer customer = null;

        Optional<CustomerData> customerData = customerDataRepository.findById(uid);
        if (customerData.isPresent()) {
            CustomerData cd = customerData.get();
            if (cd.getActive() == 1) {
                return CustomerMapper.MAPPER.toModel(customerData.get());
            }
        }
        return customer;*/
    }

    @Override
    public Customer save(Customer customer) {
        CustomerData customerData = customerDataRepository.save(CustomerMapper.MAPPER.toEntity(customer));
        return CustomerMapper.MAPPER.toModel(customerData);
    }

    @Override
    public Customer update(String uid, Customer customer) {

        /* Optional<CustomerData> customerData = customerDataRepository.findById(uid);
        if (customerData.isPresent()) {
            CustomerData customerData1 = CustomerMapper.MAPPER.toEntity(customer);
            return CustomerMapper.MAPPER.toModel(customerDataRepository.save(customerData1));
        }

        return null;*/

        CustomerData existing = customerDataRepository.findById(uid).
                orElseThrow(() -> new EntityNotFoundException("Customer not found: " + uid));

        CustomerData update = CustomerMapper.MAPPER.toEntity(customer);
        update.setUid(uid);
        return CustomerMapper.MAPPER.toModel(customerDataRepository.save(update));
    }

    @Override
    public void deleteById(String uid) {

        /*Optional<CustomerData> customer = customerDataRepository.findById(uid);
        if (customer.isPresent()) {
            CustomerData customerData = customer.get();
            customerData.setActive(0);
            customerDataRepository.save(customerData);
        }*/

        customerDataRepository.findById(uid)
                .filter(c -> c.getActive() == 1)
                .ifPresent(customerData -> {
                    customerData.setActive(0);
                    customerDataRepository.save(customerData);
                });
    }
}
