package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public List<GetCarResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) throws Throwable {
        return carService.getCarById(id);
    }

    @GetMapping("brand")
    public List<GetCarResponse> getAllCarByBrandName (@Param("name") String name){
        return carService.getAllCarByBrandName(name);
    }
    @GetMapping("available")
    public List<GetCarResponse> getAllAvailableCar(){
        return carService.getAllAvailableCar();
    }

    @PostMapping
    public AddCarResponse add(@RequestBody AddCarRequest request) throws Throwable {
        return carService.add(request);
    }

    @PutMapping()
    public UpdateCarResponse updateCar(@RequestBody UpdateCarRequest request) throws Throwable {
        return carService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
