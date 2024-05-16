package com.wsd.ayon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sales_record")
public class SalesRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer_id", nullable = false, length = 100)
    private String customerId;

    @Column(name = "sales_date", nullable = false)
    private Instant salesDate;

    @Column(name = "product_sku", length = 100)
    private String productSku;

    @Column(name = "quantity")
    private Double quantity;

}