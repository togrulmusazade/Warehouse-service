package com.company.Warehouse.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CWarehouseAmountReportDTO {

    @Id
    private Integer idProduct;
    private String productCode;
    private String productName;
    private Integer idWarehouse;
    private String warehouseName;
    private BigDecimal currentAmount;
    private Integer idProductType;
}
