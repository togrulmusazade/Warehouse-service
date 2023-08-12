package com.company.Warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "warehouse")
@Data
public class Warehouse {
    @Id
    private Integer id;
    private String name;
}