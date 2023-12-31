package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.AddRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalResponse;
import com.tobeto.rentACar.services.dtos.rental.response.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private RentalRepository rentalRepository;
    private CustomerService customerService;
    private CarService carService;
    private ModelMapperService modelMapperService;

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
    public AddRentalResponse add(AddRentalRequest request) throws Throwable {
        Customer customer = customerService.findCustomerById(request.getCustomerId());
        Car car = carService.findCarById(request.getCarId());
        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);
        rental.setCustomer(customer);
        rental.setCar(car);
        rentalRepository.save(rental);
        return this.modelMapperService.forResponse().map(rental,AddRentalResponse.class);
    }

    @Override
    public UpdateRentalResponse update(UpdateRentalRequest request) throws Throwable {
        Rental rental = rentalRepository.findById(request.getRentalId()).orElseThrow(()->
                new Throwable("Rental is not exit"));
        rental.setCustomer(customerService.findCustomerById(request.getCustomerId()));
        rental.setCar(carService.findCarById(request.getCarId()));
        this.modelMapperService.forRequest().map(request,rental);
        this.rentalRepository.save(rental);
        return this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        Rental deleteRental = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(deleteRental);
    }
}
