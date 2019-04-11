package com.gankki.data.jpa.dao;

import com.gankki.data.jpa.entity.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;


/**** imports ****/
@Mapper
public interface PurchaseRecordDao {
	public int insertPurchaseRecord(PurchaseRecordPo pr);
}