package com.wsd.ayon.repos;

import com.wsd.ayon.entities.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Integer> {
}