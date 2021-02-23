# Prices Application

Demo application to test the prices of a product from database with SpringBoot.

It will deploy a unique endpoint to check the price. Once the application is up and running, you can test it calling the following request.

```bash
curl --location --request GET 'http://localhost:8080/prices/35455?brandId=1&date=2020-06-1416:00:00'
