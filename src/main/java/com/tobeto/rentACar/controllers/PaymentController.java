package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.response.AddPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.UpdatePaymentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<GetPaymentResponse> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public AddPaymentResponse add(@RequestBody AddPaymentRequest request){
        return paymentService.add(request);
    }
    @PutMapping("{id}")
    public UpdatePaymentResponse updatePayment(@RequestBody UpdatePaymentRequest request) throws Throwable {
        return paymentService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentService.delete(id);
    }
}
