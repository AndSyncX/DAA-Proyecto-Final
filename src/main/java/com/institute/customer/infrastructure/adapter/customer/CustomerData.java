package com.institute.customer.infrastructure.adapter.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerData {

    @Id
    @Column(name = "uid", length = 40)
    private String uid;

    @Column(name = "document_number", length = 15)
    private String documentNumber;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "last_name", length = 60)
    private String lastName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "active")
    private int active;
}
