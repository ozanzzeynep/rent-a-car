package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;

import java.util.List;

public interface CarService {

    List<GetCarResponse> getAll();

    GetCarResponse getCarById(int id) throws Throwable;

    AddCarResponse add(AddCarRequest request);

    UpdateCarResponse update(UpdateCarRequest request);

    void delete (int id);



}
