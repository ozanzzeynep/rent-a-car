package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.services.dtos.car.response.GetCarResponse;
import com.tobeto.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("Select new com.tobeto.rentACar.services.dtos.car.response.GetCarResponse(c.id,c.brand.name,c.model,c.year,c.price,c.available) from Car c")
    List<GetCarResponse> getAll();

    @Query("select new com.tobeto.rentACar.services.dtos.car.response.GetCarResponse(c.id,b.name,c.model,c.year,c.price,c.available) from Car c inner join c.brand b where b.name = :name")
    List<GetCarResponse> getAllCarByBrandName(String name);

    @Query("select new com.tobeto.rentACar.services.dtos.car.response.GetCarResponse(c.id,b.name,c.model,c.year,c.price,c.available) from Car c inner join c.brand b where c.available = true")
    List<GetCarResponse> getAllAvailableCar();

}