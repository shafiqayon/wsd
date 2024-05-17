package com.wsd.ayon;

import com.wsd.ayon.controllers.WishlistController;
import com.wsd.ayon.dtos.WishListDto;
import com.wsd.ayon.services.wishlist.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WishlistController.class)
public class WishListControllerTest {
    private final String WISH_LIST_BASE_URL = "/api/wishlist/";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WishListService wishListService;

    @Test
    public void testGetTopSellingItemsByQuantity_shouldSuccess() throws Exception {
        Integer customer_id = 3;
        WishListDto wishListDto = WishListDto.builder().id(1).productName("Laptop").customerName("Bob Johnson").quantity(1.0).build();
        WishListDto wishListDto1 = WishListDto.builder().id(1).productName("Smartphone").customerName("Bob Johnson").quantity(2.0).build();
        WishListDto wishListDto2 = WishListDto.builder().id(1).productName("Headphones").customerName("Bob Johnson").quantity(2.0).build();
        WishListDto wishListDto3 = WishListDto.builder().id(1).productName("Tablet").customerName("Bob Johnson").quantity(3.0).build();
        WishListDto wishListDto4 = WishListDto.builder().id(1).productName("Camera").customerName("Bob Johnson").quantity(1.0).build();

        List<WishListDto> topSellingItems = Arrays.asList(wishListDto, wishListDto1, wishListDto2, wishListDto3, wishListDto4);

        when(wishListService.getWishList(customer_id)).thenReturn(topSellingItems);

        ResultActions resultActions = mockMvc.perform(get(WISH_LIST_BASE_URL + customer_id)
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(5))
                .andExpect(jsonPath("$[0].productName").value("Laptop"))
                .andExpect(jsonPath("$[0].quantity").value("1.0"))
                .andExpect(jsonPath("$[1].productName").value("Smartphone"))
                .andExpect(jsonPath("$[1].quantity").value("2.0"))
                .andExpect(jsonPath("$[2].productName").value("Headphones"))
                .andExpect(jsonPath("$[2].quantity").value("2.0"))
                .andExpect(jsonPath("$[3].productName").value("Tablet"))
                .andExpect(jsonPath("$[3].quantity").value("3.0"))
                .andExpect(jsonPath("$[4].productName").value("Camera"))
                .andExpect(jsonPath("$[4].quantity").value("1.0"));
    }
}
