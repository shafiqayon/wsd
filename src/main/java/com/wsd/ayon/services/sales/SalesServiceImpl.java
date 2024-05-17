package com.wsd.ayon.services.sales;

import com.wsd.ayon.repos.SalesRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {
    private final SalesRecordRepository salesRecordRepository;

    @Override
    public Double totalSaleAmountByDate(LocalDate date) {
        return salesRecordRepository.findTotalSalesAmountBySalesDate(date);
    }

    @Override
    public LocalDate findMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return salesRecordRepository.findMaxSaleDay(startDate, endDate);
    }
}