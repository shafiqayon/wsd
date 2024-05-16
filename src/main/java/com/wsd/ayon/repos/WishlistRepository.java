package com.wsd.ayon.repos;

import com.wsd.ayon.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findAllByCustomerId(String customerId);
}