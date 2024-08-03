package com.nagoorkhan.inventoryservice.repository;

import com.nagoorkhan.inventoryservice.model.InventoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryVO, Long> {
    List<InventoryVO> findBySkuCode(String skuCode);
}
