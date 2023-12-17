package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.Payment;
import com.tobeto.rentACar.repositories.PaymentRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.response.AddPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.UpdatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private  PaymentRepository paymentRepository;
    private CustomerService customerService;
    private  ModelMapperService modelMapperService;

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
    public AddPaymentResponse add(AddPaymentRequest request) throws Throwable {
        Customer customer = customerService.findCustomerById(request.getCustomerId());
        Payment payment = this.modelMapperService.forRequest().map(request,Payment.class);
        payment.setCustomer(customer);
        paymentRepository.save(payment);
        return this.modelMapperService.forResponse().map(payment,AddPaymentResponse.class);
    }

    @Override
    public UpdatePaymentResponse update(UpdatePaymentRequest request) throws Throwable {
        Payment payment = paymentRepository.findById(request.getPaymentId()).orElseThrow(()->
                new Throwable("Payment is not exits"));
        payment.setCustomer(customerService.findCustomerById(request.getCustomerId()));
        this.modelMapperService.forRequest().map(request,payment);
        this.paymentRepository.save(payment);
        return this.modelMapperService.forResponse().map(payment,UpdatePaymentResponse.class);
    }

    @Override
    public void delete(int id) {
        Payment deletePayment = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(deletePayment);
    }
}
