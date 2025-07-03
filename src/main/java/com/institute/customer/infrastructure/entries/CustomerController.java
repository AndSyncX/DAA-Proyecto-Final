package com.institute.customer.infrastructure.entries;

import com.institute.customer.domain.model.Customer;
import com.institute.customer.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instituto/customer/")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{uid}")
    ResponseEntity<Customer> getCustomerByUid(@PathVariable("uid") String uid) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(customerService.findById(uid));
    }

    @PostMapping
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(customerService.save(customer));
    }

    @PutMapping("/{uid}")
    ResponseEntity<Customer> updateCustomer(@PathVariable("uid") String uid, @RequestBody Customer customer) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(customerService.update(uid, customer));
    }

    @DeleteMapping("/{uid}")
    ResponseEntity<Void> deleteCustomerByUid(@PathVariable("uid") String uid) {
        customerService.deleteById(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
