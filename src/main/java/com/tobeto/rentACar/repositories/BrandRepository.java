package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Predicates;
import org.springframework.stereotype.Repository;

import java.util.function.Predicate;

@Repository
public interface BrandRepository extends JpaRepository <Brand,Integer>{

    @Query(value = "select count (b) from Brand b  where b.brand_name  = :name")
    int findBrandByName( String name);
}
