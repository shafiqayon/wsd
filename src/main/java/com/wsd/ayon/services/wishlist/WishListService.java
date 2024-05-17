package com.wsd.ayon.services.wishlist;

import com.wsd.ayon.dtos.WishListDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WishListService {
    public List<WishListDto> getWishList(@PathVariable Integer customer_id);
}
