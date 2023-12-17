package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.AddRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/rentals")
public class RentalController {

    private final RentalService rentalService;

    @GetMapping
    public List<GetRentalResponse> getAll(){
        return rentalService.getAll();
    }
    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return rentalService.getRentalById(id);

    }
    @PostMapping
    public AddRentalResponse add(@RequestBody AddRentalRequest request) throws Throwable {
        return rentalService.add(request);
    }

    @PutMapping("/update")
    public UpdateRentalResponse updateRental(@RequestBody UpdateRentalRequest request) throws Throwable {
        return rentalService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }
}
