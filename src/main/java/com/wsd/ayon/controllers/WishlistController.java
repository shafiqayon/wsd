package com.wsd.ayon.controllers;

import com.wsd.ayon.dtos.WishListDto;
import com.wsd.ayon.services.wishlist.WishListService;
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

    private final WishListService wishListService;

    @Transactional(readOnly = true)
    @GetMapping("/{customer_id}")
    public List<WishListDto> getWishList(@PathVariable Integer customer_id) {
        return wishListService.getWishList(customer_id);
    }
}
