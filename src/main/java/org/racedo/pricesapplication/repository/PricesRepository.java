package org.racedo.pricesapplication.repository;

import org.racedo.pricesapplication.repository.dto.PriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesRepository extends JpaRepository<PriceDto, Integer> {

  @Query(value = "SELECT TOP 1 ID, BRAND_ID, PRICE_LIST, PRICE, CURR FROM PRICES WHERE PRODUCT_ID = :productId AND BRAND_ID = :brandId "
                 + "AND START_DATE <= :date AND END_DATE >= :date ORDER BY PRIORITY DESC", nativeQuery = true)
  PriceDto getPrice(@Param("productId") String productId, @Param("brandId") Integer brand, @Param("date") LocalDateTime date);
}
