package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car,Integer> {


    @Query(value = "select c.brand from Car c inner join c.brand b where b.brand_name = :name")
    Brand findCarBrandName(@Param("name") String name);
}
