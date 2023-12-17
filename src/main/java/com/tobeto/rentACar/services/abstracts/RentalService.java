package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.AddRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.UpdateRentalResponse;

import java.util.List;

public interface RentalService {

    List<GetRentalResponse> getAll();

    GetRentalResponse getRentalById(int id);

    AddRentalResponse add(AddRentalRequest request) throws Throwable;

    UpdateRentalResponse update(UpdateRentalRequest request) throws Throwable;

    void delete(int id);

}
