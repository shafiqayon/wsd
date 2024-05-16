package com.wsd.ayon.controllers;

import com.wsd.ayon.entities.Wishlist;
import com.wsd.ayon.repos.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistRepository wishlistRepository;

    @Transactional(readOnly = true)
    @GetMapping("/{customer_id}")
    public List<Wishlist> getWishList(@PathVariable String customer_id) {
        return wishlistRepository.findAllByCustomerId(customer_id);
    }
}
