package org.racedo.pricesapplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.racedo.pricesapplication.model.Price;
import org.racedo.pricesapplication.model.exception.PriceNotFoundException;
import org.racedo.pricesapplication.service.CheckPriceUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

  private final CheckPriceUseCase checkPriceUseCase;

  @Override
  public Price checkPrice(String productId, Integer brandId, LocalDateTime date) {
    log.info("Checking price with {} {} {}", productId, brandId, date);
    try {
      return checkPriceUseCase.checkPrice(productId, brandId, date);
    } catch (PriceNotFoundException e) {
      log.error("Error checking price {} {} {}", productId, brandId, date);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
}
