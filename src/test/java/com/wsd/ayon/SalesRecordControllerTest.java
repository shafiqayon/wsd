package com.wsd.ayon;

import com.wsd.ayon.controllers.SalesController;
import com.wsd.ayon.dtos.ProductDTO;
import com.wsd.ayon.services.sales.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesController.class)
public class SalesRecordControllerTest {

    private final String SALES_RECORD_BY_DATE_API_URL = "/api/sales-record/by-date/";
    private final String MAX_SALES_RECORD_BY_DATE_API_URL = "/api/sales-record/max-sales-day/";
    private final String TOP_SALES_LIST_API_URL = "/api/sales-record/top-five-products";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SalesService salesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getTotalSalesAmount_Success() throws Exception {
        LocalDate date = LocalDate.of(2024, 5, 03);
        Double expectedTotal = 15440.0;

        when(salesService.totalSaleAmountByDate(any(LocalDate.class))).thenReturn(expectedTotal);

        mockMvc.perform(get(SALES_RECORD_BY_DATE_API_URL + date.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedTotal.toString()));
    }

    @Test
    public void getTotalSalesAmount_InvalidDateFormat() throws Exception {
        mockMvc.perform(get(SALES_RECORD_BY_DATE_API_URL + "garbage-date"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getTotalSalesAmount_NoSales() throws Exception {
        LocalDate date = LocalDate.of(2024, 6, 03);
        Double expectedTotal = 0.0;

        when(salesService.totalSaleAmountByDate(any(LocalDate.class))).thenReturn(expectedTotal);

        mockMvc.perform(get(SALES_RECORD_BY_DATE_API_URL + date.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedTotal.toString()));
    }

    @Test
    public void getMaxSaleDay_Success() throws Exception {
        LocalDate startDate = LocalDate.of(2024, 5, 1);
        LocalDate endDate = LocalDate.of(2024, 5, 31);
        LocalDate maxSaleDay = LocalDate.of(2024, 5, 5);
        String maxSaleDayString = "\"2024-05-05\"";

        when(salesService.findMaxSaleDay(startDate, endDate)).thenReturn(maxSaleDay);

        mockMvc.perform(get(MAX_SALES_RECORD_BY_DATE_API_URL + startDate.toString() + "/" + endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(maxSaleDayString));
    }

    @Test
    public void testGetTopSellingItems_success() throws Exception {
        ProductDTO product1 = ProductDTO.builder().id(1).productName("Laptop").productSku("SKU001").build();
        ProductDTO product2 = ProductDTO.builder().id(5).productName("Camera").productSku("SKU005").build();
        ProductDTO product3 = ProductDTO.builder().id(3).productName("Headphones").productSku("SKU003").build();
        ProductDTO product4 = ProductDTO.builder().id(2).productName("Smartphone").productSku("SKU002").build();
        ProductDTO product5 = ProductDTO.builder().id(4).productName("Tablet").productSku("SKU004").build();

        List<ProductDTO> topSellingItems = Arrays.asList(product1, product2, product3, product4, product5);

        when(salesService.findTopFiveProducts()).thenReturn(topSellingItems);

        ResultActions resultActions = mockMvc.perform(get(TOP_SALES_LIST_API_URL)
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(5))
                .andExpect(jsonPath("$[0].productName").value("Laptop"))
                .andExpect(jsonPath("$[0].productSku").value("SKU001"))
                .andExpect(jsonPath("$[1].productName").value("Camera"))
                .andExpect(jsonPath("$[1].productSku").value("SKU005"))
                .andExpect(jsonPath("$[2].productName").value("Headphones"))
                .andExpect(jsonPath("$[2].productSku").value("SKU003"))
                .andExpect(jsonPath("$[3].productName").value("Smartphone"))
                .andExpect(jsonPath("$[3].productSku").value("SKU002"))
                .andExpect(jsonPath("$[4].productName").value("Tablet"))
                .andExpect(jsonPath("$[4].productSku").value("SKU004"));
    }

    @Test
    public void testGetTopSellingItems_shouldFail() throws Exception {
        ProductDTO product1 = ProductDTO.builder().id(1).productName("Laptop").productSku("SKU001").build();
        ProductDTO product2 = ProductDTO.builder().id(5).productName("Camera").productSku("SKU005").build();
        ProductDTO product3 = ProductDTO.builder().id(3).productName("Headphones").productSku("SKU003").build();
        ProductDTO product4 = ProductDTO.builder().id(2).productName("Smartphone").productSku("SKU002").build();
        ProductDTO product5 = ProductDTO.builder().id(4).productName("Tablet").productSku("SKU004").build();

        List<ProductDTO> topSellingItems = Arrays.asList(product1, product2, product3, product4, product5);

        when(salesService.findTopFiveProducts()).thenReturn(topSellingItems);

        ResultActions resultActions = mockMvc.perform(get(TOP_SALES_LIST_API_URL)
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(5))
                .andExpect(jsonPath("$[0].productName").value("Laptop2"))
                .andExpect(jsonPath("$[0].productSku").value("SKU001"))
                .andExpect(jsonPath("$[1].productName").value("Camera"))
                .andExpect(jsonPath("$[1].productSku").value("SKU005"))
                .andExpect(jsonPath("$[2].productName").value("Headphones"))
                .andExpect(jsonPath("$[2].productSku").value("SKU003"))
                .andExpect(jsonPath("$[3].productName").value("Smartphone"))
                .andExpect(jsonPath("$[3].productSku").value("SKU002"))
                .andExpect(jsonPath("$[4].productName").value("Tablet"))
                .andExpect(jsonPath("$[4].productSku").value("SKU004"));
    }
}