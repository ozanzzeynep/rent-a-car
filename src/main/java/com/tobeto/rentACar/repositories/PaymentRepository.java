package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
