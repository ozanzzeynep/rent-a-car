package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.response.AddPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.GetPaymentResponse;
import com.tobeto.rentACar.services.dtos.payment.response.UpdatePaymentResponse;

import java.util.List;

public interface PaymentService {

    List<GetPaymentResponse> getAll();

    GetPaymentResponse getPaymentById(int id);

    AddPaymentResponse add(AddPaymentRequest request) throws Throwable;

    UpdatePaymentResponse update(UpdatePaymentRequest request) throws Throwable;

    void delete (int id);
}
