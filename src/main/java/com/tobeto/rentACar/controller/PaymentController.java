package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.entities.Payment;
import com.tobeto.rentACar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;


    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping("{id}")
    public Payment updatePayment(@PathVariable int id, @RequestBody Payment paymentDetails) throws Throwable {
        Payment updatePayment = paymentRepository.findById(id).orElseThrow(()->
                new Throwable("Payment is not exist with id : " + id));

        updatePayment.setCardNumber(paymentDetails.getCardNumber());
        updatePayment.setDate(paymentDetails.getDate());
        updatePayment.setCvv(paymentDetails.getCvv());

        paymentRepository.save(updatePayment);
        return updatePayment;
    }
}
