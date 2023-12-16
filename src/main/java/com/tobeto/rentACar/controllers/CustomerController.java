package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.AddCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.UpdateCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<GetCustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id) throws Throwable {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public AddCustomerResponse add(@RequestBody AddCustomerRequest request) throws Exception {
        return customerService.add(request);
    }

    @PutMapping("{id}")
    public UpdateCustomerResponse updateCustomer(@PathVariable int id, @RequestBody UpdateCustomerRequest request) throws Throwable {

        return customerService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
    }


