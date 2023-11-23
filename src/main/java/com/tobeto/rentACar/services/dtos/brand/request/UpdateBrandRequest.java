package com.tobeto.rentACar.services.dtos.brand.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private int brandId;
    private String brandName;
}
