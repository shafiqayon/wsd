package com.wsd.ayon;

import com.wsd.ayon.controllers.SalesController;
import com.wsd.ayon.services.sales.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesController.class)
public class SalesRecordControllerTest {

    private final String BASE_URL = "/api/sales-record/by-date";
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

        mockMvc.perform(get(BASE_URL + "/" + date.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedTotal.toString()));
    }

    @Test
    public void getTotalSalesAmount_InvalidDateFormat() throws Exception {
        mockMvc.perform(get(BASE_URL + "/" + "garbage-date"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getTotalSalesAmount_NoSales() throws Exception {
        LocalDate date = LocalDate.of(2024, 6, 03);
        Double expectedTotal = 0.0;

        when(salesService.totalSaleAmountByDate(any(LocalDate.class))).thenReturn(expectedTotal);

        mockMvc.perform(get(BASE_URL + "/" + date.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedTotal.toString()));
    }
}