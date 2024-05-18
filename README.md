# WSD

## Assume a reputed organization wants to start a new E-commerce business in your area. Your task will be to create an application and expose several APIs.

### apis

- Create an API to return the wish list of a customer.
  ```http://localhost:8080/api/wishlist/3```
- Create an API to return the total sale amount of the current day.
  ```http://localhost:8080/api/sales-record/by-date/2024-05-03```
- Create an API to return the max sale day of a certain time range.
  ```http://localhost:8080/api/sales-record/max-sales-day/2024-05-01/2024-05-30```
- Create an API to return top 5 selling items of all time (based on total sale amount).
  ```http://localhost:8080/api/sales-record/top-five-products-by-amount```
- Create an API to return top 5 selling items of the last month (based on number of sales).
  ```http://localhost:8080/api/sales-record/top-five-products-by-quantity```

### tech

*Frameworks:*

* Spring 3.2.5
* MySQL 8.0
* Liquibase
* MapStruct

### Docker cmd

```docker-compose up --build```
