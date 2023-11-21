package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;


    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customerDetails) throws Throwable {
        Customer updateCustomer = customerRepository.findById(id).orElseThrow(()->
                new Throwable("Customer is not exist with id : " + id));

        updateCustomer.setFirstName(customerDetails.getFirstName());
        updateCustomer.setLastName(customerDetails.getLastName());
        updateCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        updateCustomer.setEmail(customerDetails.getEmail());

        customerRepository.save(updateCustomer);
        return updateCustomer;
    }

}
