package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Payment;
import com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query("Select new com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse(p.cardNumber,p.date,p.cvv,p.customer) from Payment p")
    List<GetPaymentResponse> getAll();
}
