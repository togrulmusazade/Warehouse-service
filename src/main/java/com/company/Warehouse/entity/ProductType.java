package com.company.Warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "producttype")
@Data
public class ProductType {
    @Id
    private Integer id;
}