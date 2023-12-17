package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

    @Query("Select new com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse(r.date,r.due,r.customer.firstName,r.customer.lastName," +
            "r.car.model,r.car.price) " +
            "from Rental r")
    List<GetRentalResponse> getAll();

}
