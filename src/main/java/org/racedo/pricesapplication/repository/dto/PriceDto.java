package org.racedo.pricesapplication.repository.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICES")
@Data
public class PriceDto {

  @Id
  private String id;
  @Column
  private int brandId;
  @Column
  private int priceList;
  @Column
  private float price;
  @Column
  private String curr;
}
