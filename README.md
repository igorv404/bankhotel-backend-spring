# Bankhotel backend on Spring

[![GitHub issues](https://img.shields.io/github/issues/igorv404/bankhotel-backend-spring)](https://github.com/igorv404/bankhotel-backend-spring/issues)
[![GitHub forks](https://img.shields.io/github/forks/igorv404/bankhotel-backend-spring)](https://github.com/igorv404/bankhotel-backend-spring/network)
[![GitHub stars](https://img.shields.io/github/stars/igorv404/bankhotel-backend-spring)](https://github.com/igorv404/bankhotel-backend-spring/stargazers)

## Quick overview

This is small backend application, which is based on [Bankhotel site](https://bankhotel.com.ua/en/).

## Requirements

For this application you need to have:

- [Java 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
- [Relational database](https://en.wikipedia.org/wiki/Relational_database)

## Remark

Before starting the application you need to add parameters in `application.properties` :

```
spring.datasource.url= url to database
spring.datasource.username= name of database user
spring.datasource.password= password of database user
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect= dialect of relational database
spring.jpa.properties.hibernate.format_sql=true
```

## Admin dashboard

This application has an admin dashboard to manage rooms and reservations.
