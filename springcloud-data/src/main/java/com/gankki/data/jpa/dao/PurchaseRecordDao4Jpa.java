package com.gankki.data.jpa.dao;

import com.gankki.data.jpa.entity.PurchaseRecordPo;
import org.springframework.data.jpa.repository.JpaRepository;

/**** imports ****/
public interface PurchaseRecordDao4Jpa extends JpaRepository<PurchaseRecordPo, Long> {
}