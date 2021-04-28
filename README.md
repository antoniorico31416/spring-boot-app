# News-Feed App

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://www.java.com/)

Repository designed to develop Spring Application for learning purposes

## Description
This is an implementation of minimum  news-feed system (like Twitter). Builded with Java and Spring Boot with a HTML5 template engine. 

The application provides a registration/login module and a simple system for follow users, create posts and display recent news (latests post created by followed users)

## How to use
To clone and run this application, you'll need [Git](https://git-scm.com) and [Java](https://www.java.com/en/download/) installed on your computer.
```bash
# Clone this repository
$ git clone https://github.com/antoniorico31416/spring-boot-app.git
```
Once you cloned the repo, you need to import to some IDE or Text Editor of your preference.

## Requirements 

- Java SE 8 or later.
- [Spring](https://spring.io/)
- [Maven](https://maven.apache.org/)
- DBMS

## Config

You have to set up some parameters in order to manage the jpa persistence module:

1. Database information in `src\main\resources\application.properties`:

   ```json
     server.port={app port}
     spring.datasource.url=jdbc:{dbms}://{db-host}:{port}/{db-name}
     spring.datasource.username={user}
     spring.datasource.password={password}
     spring.jpa.show-sql = true //optional parameter to show executed queries 
   ```
   
   
