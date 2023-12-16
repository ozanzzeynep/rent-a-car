package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository <Brand,Integer>{

    @Query(value = "select count (b) from Brand b  where b.brand_name  = :name")
    int findBrandByName( String name);

    @Query("Select new com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse(b.brand_name) from Brand b ")
    List<GetBrandResponse> getAll();

    @Query("Select new com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse(b.brand_name) from Brand b where b.brand_name like concat('%', :query,'%')")
    List<GetBrandResponse> searchBrandByName(String query);




}
