package com.company.Warehouse.repository;

import com.company.Warehouse.entity.WarehouseAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseAmountRepository extends JpaRepository<WarehouseAmount, Integer> {
    @Query(value = "SELECT * FROM `warehouse_amount` WHERE IDWAREHOUSE = COALESCE(:idWarehouse, IDWAREHOUSE) " +
            "AND IDPRODUCT = COALESCE(:idProduct, IDPRODUCT) " +
            "AND IDPRODUCT = COALESCE( (SELECT id FROM product WHERE IDPRODUCTTYPE = :idProductType), IDPRODUCT) " +
            "AND IDPRODUCT = COALESCE( (SELECT id FROM product WHERE IDPRODUCTGROUP1 = :idProductGroup1), IDPRODUCT) " +
            "AND IDPRODUCT = COALESCE( (SELECT id FROM product WHERE IDPRODUCTGROUP2 = :idProductGroup2), IDPRODUCT) " +
            "AND IDPRODUCT = COALESCE( (SELECT id FROM product WHERE IDPRODUCTGROUP3 = :idProductGroup3), IDPRODUCT)", nativeQuery = true)
    List<WarehouseAmount> getWarehouseAmount(Integer idWarehouse, Integer idProduct, Integer idProductGroup1, Integer idProductGroup2, Integer idProductGroup3, Integer idProductType);
}
