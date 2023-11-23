package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;

import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.AddBrandResponse;

import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.UpdateBrandResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<GetBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandResponse> newBrandList = new ArrayList<>();
        for (Brand b : brands){
            newBrandList.add(GetBrandResponse.builder()
                            .brandName(b.getBrand_name())
                    .build());
        }
        return newBrandList;

    }

    @Override
    public GetBrandResponse getBrandById(int id) throws Throwable {
        Brand brand = brandRepository.findById(id).orElseThrow(()->
                new Throwable("Brand is not exits"));
        return GetBrandResponse.builder()
                .brandName(brand.getBrand_name()).build();

    }

    @Override
    public AddBrandResponse add(AddBrandRequest request) throws Exception {
        if(request.getName().length() < 3){
            throw new Exception("brand name cannot be less than three letters.");
        }
        int brandCount = brandRepository.findBrandByName((request.getName()));
        if(brandCount > 0){
            throw new Exception("Brand already saved.");
        }
        var brand = Brand.builder()
                        .brand_name(request.getName())
                                .build();
        Brand savedBrand = brandRepository.save(brand);
        return AddBrandResponse.builder()
                .brandId(savedBrand.getId())
                .brandName(savedBrand.getBrand_name())
                .build();
    }
    @Override
    public UpdateBrandResponse update(UpdateBrandRequest request) throws Throwable {
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(()->
                new Throwable("Brand is not exits "));
        Brand newBrand = Brand.builder().id(brand.getId())
                .brand_name(brand.getBrand_name()).build();
        //newBrand.setId(request.getBrandId());
        newBrand.setBrand_name(request.getBrandName());

        Brand savedBrand = brandRepository.save(newBrand);
        return UpdateBrandResponse.builder()
                .brandId(savedBrand.getId())
                .brandName(savedBrand.getBrand_name())
                .build();
    }
    @Override
    public void delete(int id) {
        Brand deleteBrand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(deleteBrand);
    }
}
