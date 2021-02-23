package org.racedo.pricesapplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.racedo.pricesapplication.model.Price;
import org.racedo.pricesapplication.model.exception.PriceNotFoundException;
import org.racedo.pricesapplication.repository.PricesRepository;
import org.racedo.pricesapplication.service.mapper.PriceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckPriceUseCaseImpl implements CheckPriceUseCase {

  private final PriceMapper priceMapper;
  private final PricesRepository pricesRepository;


  @Override
  public Price checkPrice(String productId, Integer brand, LocalDateTime date) throws PriceNotFoundException {
    log.info("Checking price for product {}, brand {} and date {}", productId, brand, date);
    return priceMapper.mapPrice(Optional.ofNullable(pricesRepository.getPrice(productId, brand, date))
        .orElseThrow(() -> new PriceNotFoundException(String.format("Price not found for productId %s, brand %d and date %s", productId, brand, date))));
  }
}
