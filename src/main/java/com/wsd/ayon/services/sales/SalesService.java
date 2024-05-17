package com.wsd.ayon.services.sales;

import java.time.LocalDate;

public interface SalesService {
    Double totalSaleAmountByDate(LocalDate localDate);

    LocalDate findMaxSaleDay(LocalDate startDate, LocalDate endDate);
}
