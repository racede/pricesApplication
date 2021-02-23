package org.racedo.pricesapplication.service;

import org.racedo.pricesapplication.model.Price;
import org.racedo.pricesapplication.model.exception.PriceNotFoundException;

import java.time.LocalDateTime;

public interface CheckPriceUseCase {

  Price checkPrice(String productId, Integer brand, LocalDateTime date) throws PriceNotFoundException;
}
