package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("Select new com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse(c.firstName,c.lastName,c.phoneNumber,c.email) " +
            "from Customer c")
    List<GetCustomerResponse> getAll();




}
