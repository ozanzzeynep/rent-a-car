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

    List<GetCarResponse> getAllCarByBrandName (String name);

    List<GetCarResponse> getAllAvailableCar();

    AddCarResponse add(AddCarRequest request) throws Throwable;

    UpdateCarResponse update(UpdateCarRequest request) throws Throwable;

    void delete (int id);



}
