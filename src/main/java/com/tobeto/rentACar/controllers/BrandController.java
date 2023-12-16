package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.AddBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/brands")
public class BrandController {

    //Bağımlılıklar daima soyut nesneler üzerinden olur
    private BrandService brandService;

    @GetMapping
    public List<GetBrandResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("name")
    public List<GetBrandResponse> getBrandName(@Param("query") String query){
        return brandService.searchBrandByName(query);
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) throws Throwable {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public AddBrandResponse add(@RequestBody @Valid AddBrandRequest request) throws Exception {
        return brandService.add(request);
    }

    @PutMapping()
    public UpdateBrandResponse update(@RequestBody UpdateBrandRequest request) throws Throwable {
        return brandService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){
        brandService.delete(id);
    }
}
