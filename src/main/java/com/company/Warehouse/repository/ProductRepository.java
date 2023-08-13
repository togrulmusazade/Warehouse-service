package com.company.Warehouse.repository;

import com.company.Warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT COUNT(*) FROM product WHERE IDPRODUCTGROUP1 = :id", nativeQuery = true)
    Long findByIdProductgroup1(int id);

    @Query(value = "SELECT COUNT(*) FROM product WHERE IDPRODUCTGROUP2 = :id", nativeQuery = true)
    Long findByIdProductgroup2(int id);

    @Query(value = "SELECT COUNT(*) FROM product WHERE IDPRODUCTGROUP3 = :id", nativeQuery = true)
    Long findByIdProductgroup3(int id);
}
