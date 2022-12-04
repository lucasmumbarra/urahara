
# API REST - URAHARA

API project using Spring boot, Maven and Java 11.

## Technologies
```
  # java 11.0.15
  # maven 3.8.5
  # mysql 8.0.30
  # flyway 5.2.4
```

## Setup

Run MySQL via Docker:
```
  docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql
```

Access MySQL and create the schema:

```
  create database urahara
```

Install project dependencies:

```
  mvn clean install
```

Run the unit tests:

```
  mvn clean verify
```
