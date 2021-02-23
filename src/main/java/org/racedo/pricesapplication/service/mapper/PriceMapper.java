package org.racedo.pricesapplication.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.racedo.pricesapplication.model.Price;
import org.racedo.pricesapplication.repository.dto.PriceDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

  @Mapping(source = "curr", target = "currency")
  Price mapPrice(PriceDto priceDto);
}
