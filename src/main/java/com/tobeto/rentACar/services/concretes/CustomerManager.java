package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.AddCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.UpdateCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetCustomerResponse> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public GetCustomerResponse getCustomerById(int id) throws Throwable {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new Throwable("Customer is not exits"));
        return this.modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
    }

    @Override
    public AddCustomerResponse add(AddCustomerRequest request) throws Exception {
        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return this.modelMapperService.forResponse().map(savedCustomer,AddCustomerResponse.class);
    }

    @Override
    public UpdateCustomerResponse update(UpdateCustomerRequest request) throws Throwable {
        customerRepository.findById(request.getCustomerId()).orElseThrow(()->
                new Throwable("Customer is not exits"));
        Customer newCustomer = this.modelMapperService.forRequest().map(request,Customer.class);
        Customer savedCustomer = customerRepository.save(newCustomer);
        return this.modelMapperService.forResponse().map(savedCustomer,UpdateCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        Customer deleteCustomer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(deleteCustomer);

    }
}
