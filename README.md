# README #

This README would normally document whatever steps are necessary to get your application up and running.

# Requirements to install :
* Java 17 openjdk-17.0.1
* Docker
* Docker compose
* Maven
* Postman

# Install requirements with brew 
* brew install openjdk@17
* brew install docker
* brew install docker-compose
* brew install maven


# Building
* mvn clean install
* change the profile and choose qa 

#Swagger
* http://localhost:8082/swagger-ui.html

# Building the docker image
* docker-compose build
* List docker images

# Running application with docker-compose
* docker-compose up
* 
# Running the mysql database
* run the script in mysql resources/data.sql


# Api
* POST  curl --location 'localhost:8082/api/user' \--header 'Content-Type: application/json' \--data-raw '{"fullName": "Juan Rodriguez","email": "juan@rodriguez.org","password": "hunter2","phones": [{"number": "1234567","cityCode": "1","countryCode": "57"}]}'
### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines
