package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.AddRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.UpdateRentalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;

    public RentalManager(RentalRepository rentalRepository, CustomerRepository customerRepository, CarRepository carRepository, ModelMapperService modelMapperService) {
        this.rentalRepository = rentalRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<GetRentalResponse> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public GetRentalResponse getRentalById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(rental, GetRentalResponse.class);
    }

    @Override
    public AddRentalResponse add(AddRentalRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();
        Car car = carRepository.findById(request.getCarId()).orElseThrow();
        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);
        rentalRepository.save(rental);
        return this.modelMapperService.forResponse().map(rental,AddRentalResponse.class);
    }

    @Override
    public UpdateRentalResponse update(UpdateRentalRequest request) throws Throwable {
        rentalRepository.findById(request.getRentalId()).orElseThrow(()->
                new Throwable("Rental is not exit"));

        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();
        Car car = carRepository.findById(request.getCarId()).orElseThrow();

        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);

        return this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        Rental deleteRental = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(deleteRental);
    }
}
