package com.wsd.ayon.services.sales;

import com.wsd.ayon.dtos.ProductDTO;

import java.time.LocalDate;
import java.util.List;

public interface SalesService {
    Double totalSaleAmountByDate(LocalDate localDate);

    LocalDate findMaxSaleDay(LocalDate startDate, LocalDate endDate);

    List<ProductDTO> findTopFiveProductsByAmount();

    List<ProductDTO> findTopFiveProductsByQuantity();
}
