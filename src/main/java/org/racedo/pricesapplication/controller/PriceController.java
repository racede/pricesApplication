package org.racedo.pricesapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.racedo.pricesapplication.model.Price;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequestMapping("prices")
@Tag(name = "Price", description = "Check price for product")
public interface PriceController {

  @GetMapping(path = "{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(description = "Get a price for a product",
      parameters = {
          @Parameter(in = ParameterIn.PATH, name = "productId",
              description = "Id of the product",
              example = "35455"),
          @Parameter(in = ParameterIn.QUERY, name = "brandId",
              description = "Id of the brand",
              example = "1",
              required = true),
          @Parameter(in = ParameterIn.QUERY, name = "date",
              description = "Date to check the price. Format yyyy-MM-ddHH:mm:ss",
              example = "2020-06-1417:45:00",
              required = true)
      })
  Price checkPrice(@PathVariable String productId, @RequestParam Integer brandId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss") LocalDateTime date);
}
