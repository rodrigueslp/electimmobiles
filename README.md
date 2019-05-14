# Elect Immobiles

Elect immobiles from link based on code challenge and storage the datas in memory

## Main Technologies
- Java 8

- Spring Boot 2.1.4
    - spring-boot-starter
    - spring-boot-starter-web
    
- Tomcat (Embedded no Spring Boot)

## Execution
Application execution is done through a Maven command that initiates a Spring Boot boot.

#### Dependencies
Download dependencies and install
- mvn package
- mvn install

#### Tests
- mvn test

#### Running application
- mvn spring-boot:run

## Utilization

**VivaReal API:**
```
GET → /vivareal/{page}/{limit}
```
**response:**
<p>code = 200, message = "Successfully retrieved list"</p>
<p>code = 404, message = "Invalid parameters")</p>
<p>code = 404, message = "Maximum limit per page is 50 records")</p>

#### DNA stats
**api link:** <a hreg="https://dna-simios.herokuapp.com/stats">https://dna-simios.herokuapp.com/stats</a>

**VivaReal API:**
```
GET → /vivareal/{page}/{limit}
```
**response:**
<p>code = 200, message = "Successfully retrieved list"</p>
<p>code = 404, message = "Invalid parameters")</p>
<p>code = 404, message = "Maximum limit per page is 50 records")</p>

#### Swagger

The details endpoints are described on swagger link bellow

<a hreg="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>
