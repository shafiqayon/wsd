package com.wsd.ayon.controllers;

import com.wsd.ayon.dtos.ProductDTO;
import com.wsd.ayon.exceptionhandlers.BadRequestException;
import com.wsd.ayon.services.sales.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("api/sales-record")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @GetMapping("/by-date/{salesDate}")
    public Double getSalesAmountByDate(@PathVariable String salesDate) {
        LocalDate date = LocalDate.now();
        try {
            date = LocalDate.parse(salesDate, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid date format. Please use 'YYYY-MM-DD'.");
        }
        return salesService.totalSaleAmountByDate(date);
    }

    @GetMapping("/max-sales-day/{startDate}/{endDate}")
    public LocalDate getSalesAmountByDate(@PathVariable String startDate, @PathVariable String endDate) {
        LocalDate startDateConverted = LocalDate.now();
        LocalDate endDateConverted = LocalDate.now();
        try {
            startDateConverted = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
            endDateConverted = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid date format. Please use 'YYYY-MM-DD'.");
        }
        return salesService.findMaxSaleDay(startDateConverted, endDateConverted);
    }

    @GetMapping("/top-five-products")
    public List<ProductDTO> findTopFiveProducts() {
        return salesService.findTopFiveProducts();
    }
}
