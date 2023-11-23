package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;
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


    @PostMapping
    public AddCarResponse add(@RequestBody AddCarRequest request){
        AddCarRequest carRequest = AddCarRequest.builder()
                .name(request.getName())
                .model(request.getModel())
                .year(request.getYear())
                .price(request.getPrice())
                .available(request.isAvailable())
                .build();
        return carService.add(carRequest);
    }

    @PutMapping("{id}")
    public UpdateCarResponse updateCar(@PathVariable int id, @RequestBody UpdateCarRequest request) throws Throwable {
        UpdateCarRequest carRequest = UpdateCarRequest.builder()
                        .brand(request.getBrand())
                                .id(request.getId())
                                        .model(request.getModel())
                                                .year(request.getYear())
                .price(request.getPrice())
                .available(request.isAvailable())
                .build();

        return carService.update(carRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
