package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.AddCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.UpdateCarResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private BrandService brandService;
    private ModelMapperService modelMapperService;

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
        Brand brand = brandService.findBrandById(request.getBrandId());
        Car car = this.modelMapperService.forRequest().map(request,Car.class);
        car.setBrand(brand);
        carRepository.save(car);
        return this.modelMapperService.forResponse().map(car,AddCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest request) throws Throwable {
        Car car = carRepository.findById(request.getCarId()).orElseThrow(() ->
                 new Exception("Car is not exist"));
        car.setBrand(brandService.findBrandById(request.getBrandId()));
        this.modelMapperService.forRequest().map(request,car);
        this.carRepository.save(car);
        return this.modelMapperService.forResponse().map(car,UpdateCarResponse.class);
    }
    @Override
    public void delete(int id) {
        Car deleteCar = carRepository.findById(id).orElseThrow();
        carRepository.delete(deleteCar);
    }

    @Override
    public Car findCarById(int id) throws Throwable {
        return carRepository.findById(id).orElseThrow(()->
                new Throwable("Car is not exits"));
    }
}
