package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalController {

    private final RentalRepository rentalRepository;

    public RentalController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){
        List<Rental> rentals = rentalRepository.findAll();
        return rentals;
    }
    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public Rental updateRental(@PathVariable int id,@RequestBody Rental rentalDetails) throws Throwable {
        Rental updateRental = rentalRepository.findById(id).orElseThrow(()->
                new Throwable("Rental is not exist with id : " + id));

        updateRental.setDate(rentalDetails.getDate());
        updateRental.setDue(rentalDetails.getDue());

        rentalRepository.save(updateRental);
        return updateRental;
    }
}
