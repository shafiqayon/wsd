package com.wsd.ayon.repos;

import com.wsd.ayon.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}