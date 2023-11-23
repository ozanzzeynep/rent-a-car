package com.tobeto.rentACar.controller;

import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.AddBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.brand.response.UpdateBrandResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    //Bağımlılıklar daima soyut nesneler üzerinden olur
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<GetBrandResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) throws Throwable {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public AddBrandResponse add(@RequestBody AddBrandRequest request) throws Exception {
        AddBrandRequest brandRequest = AddBrandRequest.builder().name(request.getName()).build();
        return brandService.add(brandRequest);
    }

    @PutMapping("{id}")
    public UpdateBrandResponse updateBrand(@RequestBody UpdateBrandRequest request) throws Throwable {
        UpdateBrandRequest brandRequest = UpdateBrandRequest.builder()
                .brandId(request.getBrandId())
                .brandName(request.getBrandName()).build();
        return brandService.update(brandRequest);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){
        brandService.delete(id);
    }
}
