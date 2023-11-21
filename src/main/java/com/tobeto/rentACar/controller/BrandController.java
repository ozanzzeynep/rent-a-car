package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @PutMapping("{id}")
    public Brand updateBrand(@PathVariable int id,@RequestBody Brand brandDetails) throws Throwable {
        Brand updateBrand = brandRepository.findById(id).orElseThrow(()->
                new Throwable("Brand not exist with id : " + id));

        updateBrand.setBrand_name(brandDetails.getBrand_name());
        brandRepository.save(updateBrand);
        return updateBrand;
    }

}
