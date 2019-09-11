package com.projettisaseptembre.test.dao;

import com.projettisaseptembre.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcuctDao extends JpaRepository<Product,Integer> {
    public Product findById(int id);
    public List<Product> findByPrixGreaterThan(int prix);
    @Query("select p from Product p where p.prix >= :prix ")
    public List<Product> queryfindByPrixGreaterThan(@Param("prix") int prix);
}
