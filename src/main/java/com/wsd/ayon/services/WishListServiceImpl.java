package com.wsd.ayon.services;

import com.wsd.ayon.dtos.WishListDto;
import com.wsd.ayon.repos.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishlistRepository wishlistRepository;

    @Override
    public List<WishListDto> getWishList(Integer customer_id) {
        log.info("returning wish list of customer id : " + customer_id);
        return wishlistRepository.findAllByCustomerId(customer_id).stream()
                .map(wishlist -> WishListDto.builder()
                        .id(wishlist.getId())
                        .customerName(wishlist.getCustomer().getName())
                        .productName(wishlist.getProduct().getName())
                        .quantity(wishlist.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
}
