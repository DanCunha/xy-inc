# xy-inc
Teste Zup

## Installation

### Running Database

With docker installed run command bellow.
````
docker run --name postgreSQL -p 5433:5432 --restart=always  -e POSTGRES_PASSWORD=postgres -d postgres
````

### Running API
To run the API is required to have **Maven** and **Java 11** installed.
````
mvn clean spring-boot:run
````
To access the API: [http://localhost:8090/api/swagger-ui.html#/] 

### Running API Test
To run the API is required to have **Maven** and **Java 11** installed.
````
mvn clean test
````