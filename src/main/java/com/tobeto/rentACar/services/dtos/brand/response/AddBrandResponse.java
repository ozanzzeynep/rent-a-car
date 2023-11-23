package com.tobeto.rentACar.services.dtos.brand.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddBrandResponse {

    private int brandId;
    private String brandName;

}
