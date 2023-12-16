package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    public CarManager(CarRepository carRepository, BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetCarResponse> getAll() {
        return carRepository.getAll();
    }

    @Override
    public GetCarResponse getCarById(int id) throws Throwable {
        Car car = carRepository.findById(id).orElseThrow(()->
                new Throwable("Car is not exits"));
        return this.modelMapperService.forResponse().map(car,GetCarResponse.class);
    }

    @Override
    public List<GetCarResponse> getAllCarByBrandName(String name) {
        return carRepository.getAllCarByBrandName(name);
    }

    @Override
    public List<GetCarResponse> getAllAvailableCar() {
        return carRepository.getAllAvailableCar();
    }

    @Override
    public AddCarResponse add(AddCarRequest request) throws Throwable {
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(()->
                new Throwable("Brand is not exits"));
        Car car = this.modelMapperService.forRequest().map(request,Car.class);
        carRepository.save(car);
        return this.modelMapperService.forResponse().map(car,AddCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest request) throws Throwable {
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(()->
                new Throwable("Brand is not exits"));
        Car newCar = carRepository.findById(request.getCarId()).orElseThrow(()->
                new Throwable("Car is not exits"));
        this.carRepository.save(newCar);
        return this.modelMapperService.forResponse().map(newCar,UpdateCarResponse.class);
    }
    @Override
    public void delete(int id) {
        Car deleteCar = carRepository.findById(id).orElseThrow();
        carRepository.delete(deleteCar);
    }
}
