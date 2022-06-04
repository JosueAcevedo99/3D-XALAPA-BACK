package com.productos.back.persistence.repository;

import com.productos.back.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Modifying
    @Query(value = "UPDATE PRODUCTO SET TITLE='exitUpdate' WHERE ID=:id", nativeQuery = true)
    public void updateProducto(@Param("id") Long id);

}
