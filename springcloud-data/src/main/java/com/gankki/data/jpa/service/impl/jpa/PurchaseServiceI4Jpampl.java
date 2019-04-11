package com.gankki.data.jpa.service.impl.jpa;

import com.gankki.data.jpa.dao.ProductDao4Jpa;
import com.gankki.data.jpa.dao.PurchaseRecordDao4Jpa;
import com.gankki.data.jpa.entity.ProductPo;
import com.gankki.data.jpa.entity.PurchaseRecordPo;
import com.gankki.data.jpa.service.jpa.PurchaseService4Jpa;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**** imports ****/
@Service
public class PurchaseServiceI4Jpampl implements PurchaseService4Jpa {

	@Autowired
	private ProductDao4Jpa productDao4Jpa;
	@Autowired
	private PurchaseRecordDao4Jpa purchaseRecordDao4Jpa;

	/**
	 * 处理购买业务
	 *
	 * @param userId    用户编号
	 * @param productId 产品编号
	 * @param quantity  购买数量
	 * @return 成功or失败
	 */
	@Override
	@Transactional
	public boolean purchase(Long userId, Long productId, int quantity) {
		//获取产品
		ProductPo product = productDao4Jpa.getProductById(productId);
		//比较库存和购买数量
		if (product.getStock() < quantity) {
			//库存不足
			return false;
		}
		// 扣减库存
		product.setStock(product.getStock() - quantity);
		productDao4Jpa.save(product);
		//productDao4Jpa.decreaseProduct(productId, quantity);
		//初始化购买记录
		PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
		// 插入购买记录
		purchaseRecordDao4Jpa.save(pr);
		return true;
	}

	//初始化购买信息
	private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
		PurchaseRecordPo pr = new PurchaseRecordPo();
		pr.setNote("购买日志，时间：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		pr.setPrice(product.getPrice());
		pr.setProductId(product.getId());
		pr.setQuantity(quantity);
		double sum = product.getPrice() * quantity;
		pr.setSum(sum);
		pr.setUserId(userId);
		return pr;
	}
}