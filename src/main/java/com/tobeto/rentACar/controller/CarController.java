package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
    @PutMapping("{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car carDetails) throws Throwable {
        Car updateCar = carRepository.findById(id).orElseThrow(()->
                new Throwable("Car is not exist with id : "  + id));

        updateCar.setModel(carDetails.getModel());
        updateCar.setYear(carDetails.getYear());
        updateCar.setPrice(carDetails.getPrice());
        updateCar.setAvailable(carDetails.isAvailable());

        carRepository.save(updateCar);
        return updateCar;
    }
}
