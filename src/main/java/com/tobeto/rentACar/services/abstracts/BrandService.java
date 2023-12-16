package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.AddBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.UpdateBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetBrandResponse> getAll();

    List<GetBrandResponse> searchBrandByName(String query);

    GetBrandResponse getBrandById(int id) throws Throwable;

    AddBrandResponse add(AddBrandRequest request) throws Exception;

    UpdateBrandResponse update(UpdateBrandRequest request) throws Throwable;

    void delete(int id);

}
