package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;

import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.AddBrandResponse;

import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.UpdateBrandResponse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetBrandResponse> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public List<GetBrandResponse> searchBrandByName(String query) {
        return brandRepository.searchBrandByName(query);
    }

    @Override
    public GetBrandResponse getBrandById(int id) throws Throwable {
        Brand brand = this.brandRepository.findById(id).orElseThrow(()->
                new Throwable("Brand is not exits"));
        return this.modelMapperService.forResponse().map(brand,GetBrandResponse.class);
    }
    @Override
    public AddBrandResponse add(AddBrandRequest request) throws Exception {
        Brand brand = this.modelMapperService.forRequest().map(request,Brand.class);
        this.brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand,AddBrandResponse.class);

    }
    @Override
    public UpdateBrandResponse update(UpdateBrandRequest request) throws Throwable {
        brandRepository.findById(request.getId()).orElseThrow(()->
                new Throwable("Brand is not exits"));
        Brand brand = this.modelMapperService.forRequest().map(request,Brand.class);
        this.brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand,UpdateBrandResponse.class);

    }
    @Override
    public void delete(int id) {
        Brand deleteBrand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(deleteBrand);
    }

    @Override
    public Brand findBrandById(int id) throws Throwable {
        return brandRepository.findById(id).orElseThrow(()->
                new Throwable ("Brand is not exits"));
    }
}
