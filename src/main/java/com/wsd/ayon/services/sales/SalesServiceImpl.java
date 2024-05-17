package com.wsd.ayon.services.sales;

import com.wsd.ayon.dtos.ProductDTO;
import com.wsd.ayon.mapper.ProductMapper;
import com.wsd.ayon.repos.SalesRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SalesServiceImpl implements SalesService {
    private final SalesRecordRepository salesRecordRepository;
    private final ProductMapper productMapper;

    @Override
    public Double totalSaleAmountByDate(LocalDate date) {
        return salesRecordRepository.findTotalSalesAmountBySalesDate(date);
    }

    @Override
    public LocalDate findMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return salesRecordRepository.findMaxSaleDay(startDate, endDate);
    }

    @Override
    public List<ProductDTO> findTopFiveProducts() {
        return salesRecordRepository.findTopFiveSellingProducts().stream().map(productMapper::toDto).collect(Collectors.toList());

    }
}
