package org.racedo.pricesapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.racedo.pricesapplication.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PricesApplicationTests {

  private static final String PRODUCT_ID = "35455";
  private static final String BRAND_ID = "1";

  @Autowired
  private MockMvc mvc;

  private ObjectMapper objectMapper;

  @BeforeEach
  public void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  @SneakyThrows
  void test1() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1410:00:00"))
        .andExpect(status().is2xxSuccessful()).andReturn();

    assertEquals(200, result.getResponse().getStatus());

    Price price = objectMapper.readValue(result.getResponse().getContentAsString(), Price.class);
    assertEquals(35.50F, price.getPrice());
  }

  @Test
  @SneakyThrows
  void test2() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1416:00:00"))
        .andExpect(status().is2xxSuccessful()).andReturn();

    assertEquals(200, result.getResponse().getStatus());

    Price price = objectMapper.readValue(result.getResponse().getContentAsString(), Price.class);
    assertEquals(25.45F, price.getPrice());
  }

  @Test
  @SneakyThrows
  void test3() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1421:00:00"))
        .andExpect(status().is2xxSuccessful()).andReturn();

    assertEquals(200, result.getResponse().getStatus());

    Price price = objectMapper.readValue(result.getResponse().getContentAsString(), Price.class);
    assertEquals(35.50F, price.getPrice());
  }

  @Test
  @SneakyThrows
  void test4() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1510:00:00"))
        .andExpect(status().is2xxSuccessful()).andReturn();

    assertEquals(200, result.getResponse().getStatus());

    Price price = objectMapper.readValue(result.getResponse().getContentAsString(), Price.class);
    assertEquals(30.50F, price.getPrice());
  }

  @Test
  @SneakyThrows
  void test5() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1621:00:00"))
        .andExpect(status().is2xxSuccessful()).andReturn();

    assertEquals(200, result.getResponse().getStatus());

    Price price = objectMapper.readValue(result.getResponse().getContentAsString(), Price.class);
    assertEquals(38.95F, price.getPrice());
  }

  @Test
  @SneakyThrows
  void testUnknownBrand() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", "2")
        .queryParam("date", "2020-06-1621:00:00"))
        .andExpect(status().is4xxClientError()).andReturn();

    assertEquals(404, result.getResponse().getStatus());
  }

  @Test
  @SneakyThrows
  void testUnknownProduct() {
    MvcResult result = mvc.perform(get("/prices/{productId}", "66755")
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-1621:00:00"))
        .andExpect(status().is4xxClientError()).andReturn();

    assertEquals(404, result.getResponse().getStatus());
  }

  @Test
  @SneakyThrows
  void testWrongDateFormat() {
    MvcResult result = mvc.perform(get("/prices/{productId}", PRODUCT_ID)
        .queryParam("brandId", BRAND_ID)
        .queryParam("date", "2020-06-16-21:00:00"))
        .andExpect(status().is4xxClientError()).andReturn();

    assertEquals(400, result.getResponse().getStatus());
  }


}
