package com.tobeto.rentACar.services.dtos.brand.response;


import com.tobeto.rentACar.entities.Brand;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBrandResponse {
    private String brandName;
}
