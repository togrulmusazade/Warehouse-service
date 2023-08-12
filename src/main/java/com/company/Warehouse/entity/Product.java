package com.company.Warehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String code;
    private String name;
//    @Column(name = "IDPRODUCTTYPE")
//    private Integer idProductType;
    @Column(name = "IDPRODUCTGROUP1")
    private Integer idproductgroup1;
    @Column(name = "IDPRODUCTGROUP2")
    private Integer idproductgroup2;
    @Column(name = "IDPRODUCTGROUP3")
    private Integer idproductgroup3;
    @ManyToOne
    @JoinColumn(name = "IDPRODUCTTYPE", referencedColumnName = "ID", nullable = false)
    private ProductType producttypeByIdproducttype;

}
