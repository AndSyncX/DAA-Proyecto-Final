package com.institute.customer.domain.model;

public record Customer(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        int active
) {
}
