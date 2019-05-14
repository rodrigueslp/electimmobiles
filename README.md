# Elect Immobiles

Elect immobiles from link based on code challenge 

## Main Technologies
- Java 8

- Spring Boot 2.1.4
    - spring-boot-starter
    - spring-boot-starter-web
    
- Tomcat (Embedded no Spring Boot)

## Execution
Application execution is done through a Maven command that initiates a Spring Boot boot.

- mvn package
- mvn install
- mvn spring-boot:run

## Features

#### Swagger
<a hreg="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>

#### Register new DNAs
**api link:** <a hreg="https://dna-simios.herokuapp.com/simian">https://dna-simios.herokuapp.com/simian</a>

**request example:**
```
POST → /simian
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
```
**response:**
<p>Case is simian: HTTP 200-OK</p>
<p>Case is human: HTTP 403-FORBIDDEN</p>

#### DNA stats
**api link:** <a hreg="https://dna-simios.herokuapp.com/stats">https://dna-simios.herokuapp.com/stats</a>

**request example:**
```
GET → /stats
```
**response example:**
```
{"count_mutant_dna": 50, "count_human_dna": 200: "ratio": 0.25}
```



## Obs
How the app was deployed on Heroku, in the first access can be app is will in "sleep mode", making the first access more slow.