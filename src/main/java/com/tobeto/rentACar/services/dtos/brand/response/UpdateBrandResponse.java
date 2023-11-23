package com.tobeto.rentACar.services.dtos.brand.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBrandResponse {

    private int brandId;
    private String brandName;
}
