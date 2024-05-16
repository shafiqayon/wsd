package com.wsd.ayon.repos;

import com.wsd.ayon.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}