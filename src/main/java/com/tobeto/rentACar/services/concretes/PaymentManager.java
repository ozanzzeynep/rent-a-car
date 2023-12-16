package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.Payment;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.repositories.PaymentRepository;
import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.response.AddPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.UpdatePaymentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    public PaymentManager(PaymentRepository paymentRepository, CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetPaymentResponse> getAll() {
        return paymentRepository.getAll();
    }

    @Override
    public GetPaymentResponse getPaymentById(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(payment, GetPaymentResponse.class);
    }

    @Override
    public AddPaymentResponse add(AddPaymentRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();
        Payment payment = this.modelMapperService.forRequest().map(request,Payment.class);
        paymentRepository.save(payment);
        return this.modelMapperService.forResponse().map(payment,AddPaymentResponse.class);
    }

    @Override
    public UpdatePaymentResponse update(UpdatePaymentRequest request) {
        Payment payment = this.modelMapperService.forResponse().map(request,Payment.class);
        paymentRepository.save(payment);
        return this.modelMapperService.forResponse().map(payment,UpdatePaymentResponse.class);
    }

    @Override
    public void delete(int id) {
        Payment deletePayment = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(deletePayment);
    }
}
