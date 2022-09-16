package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProjectionProductNameDTO;
import com.devsuperior.uri2621.projections.ProjectionProductName;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  /*
  SELECT products.name FROM products
  INNER JOIN providers
  ON providers.id = products.id_providers
  WHERE products.amount
  BETWEEN 10
  AND 20
  AND providers.name
  LIKE 'P%'
  */
  @Query(
    nativeQuery = true,
    value = "SELECT products.name " +
    "FROM products " +
    "INNER JOIN providers ON products.id_providers = providers.id " +
    "WHERE products.amount BETWEEN :min AND :max " +
    "AND providers.name LIKE UPPER(CONCAT(:beginName, '%'))"
  )
  List<ProjectionProductName> search1(Integer min, Integer max, String beginName);

  @Query("SELECT new com.devsuperior.uri2621.dto.ProjectionProductNameDTO(obj.name) " +
      "FROM Product obj " +
      "WHERE obj.amount BETWEEN :min AND :max " +
      "AND obj.provider.name LIKE UPPER(CONCAT(:beginName, '%'))"
  )
  List<ProjectionProductNameDTO> search2(Integer min, Integer max, String beginName);

}
