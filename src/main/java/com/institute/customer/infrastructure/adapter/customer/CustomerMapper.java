package com.institute.customer.infrastructure.adapter.customer;

import com.institute.customer.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);
    Customer toModel(CustomerData entity);
    CustomerData toEntity(Customer model);
}
