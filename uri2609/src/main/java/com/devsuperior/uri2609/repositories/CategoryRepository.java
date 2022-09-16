package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2609.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  /*
    SELECT categories.name, SUM(products.amount) sum
    FROM categories
    INNER JOIN products
    ON products.id_categories = categories.id
    GROUP BY categories.name
    ORDER BY categories.name
  */
  @Query(nativeQuery = true, value = "SELECT categories.name, SUM(products.amount) sum FROM categories " +
    "INNER JOIN products ON categories.id =  products.id_categories " +
    "GROUP BY categories.name " + "ORDER BY categories.name ")
  List<CategorySumProjection> search1();

  @Query("SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) " +
    "FROM Product obj " +
    "GROUP BY obj.category.name " + "ORDER BY obj.category.name ")
  List<CategorySumDTO> search2();
}
