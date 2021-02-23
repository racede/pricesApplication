package org.racedo.pricesapplication.model;

import lombok.Data;

@Data
public class Price {
  private int brandId;
  private int priceList;
  private float price;
  private String currency;
}
