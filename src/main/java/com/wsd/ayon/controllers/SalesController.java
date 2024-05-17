package com.wsd.ayon.controllers;

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
}
