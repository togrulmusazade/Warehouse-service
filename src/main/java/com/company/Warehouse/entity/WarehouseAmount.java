package com.company.Warehouse.entity;

import com.company.Warehouse.entity.Product;
import com.company.Warehouse.entity.Warehouse;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "warehouse_amount")
@Data
public class WarehouseAmount {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "AMOUNT")
    private BigDecimal currentamount;
//    @Basic
//    @Column(name = "IDPRODUCT")
//    private int idproduct;
//    @Basic
//    @Column(name = "IDWAREHOUSE")
//    private int idwarehouse;

//    @ManyToOne
//    @JoinColumn(name = "warehouse_id")
//    private Warehouse warehouse;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

//    private BigDecimal currentAmount;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCT", referencedColumnName = "ID", nullable = false)
    private Product productByIdproduct;
    @ManyToOne
    @JoinColumn(name = "IDWAREHOUSE", referencedColumnName = "ID", nullable = false)
    private Warehouse warehouseByIdwarehouse;

}