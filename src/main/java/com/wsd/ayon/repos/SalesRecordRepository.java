package com.wsd.ayon.repos;

import com.wsd.ayon.entities.Product;
import com.wsd.ayon.entities.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Integer> {
    @Query("SELECT SUM(salesRecord.quantity * product.price) FROM SalesRecord salesRecord JOIN salesRecord.product product WHERE salesRecord.salesDate = :salesDate")
    Double findTotalSalesAmountBySalesDate(@Param("salesDate") LocalDate salesDate);

    @Query("SELECT salesRecord.salesDate FROM SalesRecord salesRecord WHERE salesRecord.salesDate BETWEEN :startDate AND :endDate GROUP BY salesRecord.salesDate ORDER BY SUM(salesRecord.quantity) DESC limit 1")
    LocalDate findMaxSaleDay(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT salesRecord.product FROM SalesRecord salesRecord JOIN salesRecord.product product GROUP BY salesRecord.product  ORDER BY SUM(salesRecord.quantity) DESC limit 5")
    List<Product> findTopFiveSellingProducts();

    @Query("SELECT sr.product, SUM(sr.quantity * sr.product.price) AS totalSalesPrice " +
            "FROM SalesRecord sr " +
            "GROUP BY sr.product " +
            "ORDER BY totalSalesPrice DESC")
    List<Object[]> findTopProductsBySalesPrice();
}