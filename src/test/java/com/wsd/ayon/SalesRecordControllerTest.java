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

    private final String SALES_RECORD_BY_DATE_API_URL = "/api/sales-record/by-date/";
    private final String MAX_SALES_RECORD_BY_DATE_API_URL = "/api/sales-record/max-sales-day/";
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
}