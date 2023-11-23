package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<GetCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarResponse> newCarList = new ArrayList<>();
        for(Car c : cars){
            newCarList.add(GetCarResponse.builder()
                            .brandName(c.getBrand().getBrand_name())
                            .model(c.getModel())
                            .year(c.getYear())
                            .price(c.getPrice())
                            .available(c.isAvailable())
                    .build());
        }
        return newCarList;
    }

    @Override
    public GetCarResponse getCarById(int id) throws Throwable {
        Car car = carRepository.findById(id).orElseThrow(()->
                new Throwable("Car is not exits"));
        return GetCarResponse.builder()
                .brandName(car.getBrand().getBrand_name())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .available(car.isAvailable())
                .build();
    }

    @Override
    public AddCarResponse add(AddCarRequest request) {
        Brand brand = carRepository.findCarBrandName(request.getName());
        Car car = Car.builder()
                .brand(brand)
                .model(request.getModel())
                .year(request.getYear())
                .price(request.getPrice())
                .available(request.isAvailable())
                .build();
        Car savedCar = carRepository.save(car);

        return AddCarResponse.builder()
                .brand(savedCar.getBrand().getBrand_name())
                .model(savedCar.getModel())
                .year(savedCar.getYear())
                .price(savedCar.getPrice())
                .available(savedCar.isAvailable())
                .build();
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest request) {
        Brand foundBrand = carRepository.findCarBrandName(request.getBrand());
        Car newCar = Car.builder().brand(foundBrand)
                .id(request.getId())
                .model(request.getModel())
                .year(request.getYear())
                .price(request.getPrice())
                .available(request.isAvailable())
                .build();
        newCar.setModel(request.getModel());
        newCar.setYear(request.getYear());
        newCar.setPrice(request.getPrice());
        newCar.setAvailable(request.isAvailable());
        Car savedCar = carRepository.save(newCar);
        return UpdateCarResponse.builder()
                .brand(savedCar.getBrand().getBrand_name())
                .model(savedCar.getModel())
                .year(savedCar.getYear())
                .price(savedCar.getPrice())
                .available(savedCar.isAvailable())
                .build();
    }

    @Override
    public void delete(int id) {
        Car deleteCar = carRepository.findById(id).orElseThrow();
        carRepository.delete(deleteCar);
    }


}
