# ProjectMicroservicesUltraDev
This is our academic project and our first step towards mastering microservices

Travel agency Microservices Project:
Description
We have chosen as theme for our project  "Travel agency".
we have distributed this project into multuple microservices

Distributed architecture or distributed computing refers to an information system or a network for which all the available resources are not located in the same place or on the same machine for this we used Docker.

The frameworks used in this app : Spring Boot for the Backend
                                  ReactJs as the Frontend.

6 services are implemented: User(NodeJs), Hotels, reclamation, promotions, restaurants/famous places and blogs.

The servers are: Eureka, API Gateway.

Overview
The architecture is composed by eight services: Eureka: Service Discovery Server created with Eureka

User:  NodeJS,ExpressJs and mongodb

Hotel: Spring Boot, Spring Data JPA, Mysql

Reclamation:  Spring Boot, Spring Data JPA, H2

Promotions: Spring Boot, Spring Data JPA, H2

Restaurant/Place :  Spring Boot, Spring Data JPA, H2

Blog: Spring Boot, Spring Data JPA, H2

Tools :


-IDE STS-3.4.9-RELEASE Eclipse Visual Studio.
-Intellij

-H2, MongoDb

-JDK 1.8

-Docker Desktop

Microservice Running Process:
we used a command "docker-compose up" that exploits the docker-compose file which holds all configurations of all the services,databases and serves that will be dockerized
and as result a multi container that wil run all our services will be created  on docker desktop .

Eureka Service
Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.

Eureka Server is also known as Discovery Server.

Implementing a Eureka Server for service registry is as easy as we need to add @EnableEurekaServer annotation.

The @EnableEurekaServer annotation is used to make your Spring Boot application acts as a Eureka Server.

@SpringBootApplication @EnableEurekaServer public class EurekaApplication { public static void main(String[] args) {

	SpringApplication.run(EurekaApplication.class, args);
}
}

we should make sure Spring cloud Eureka server dependency is added in our build configuration file. The code for Maven user dependency is shown below −

org.springframework.cloud spring-cloud-starter-netflix-eureka-server
By default, the Eureka Server registers itself into the discovery. we added the below given configuration into our application.properties

Give a name to the eureka server
spring.application.name=eureka-service

default port for eureka server
server.port=8761 eureka.client.register-with-eureka=false eureka.client.fetch-registry=false

eureka by default will register itself as a client. So, we need to set it to false.

Client MS
eureka.client.register-with-eureka=true eureka.client.fetch-registry=false

API Gateway Service
A common problem, when building microservices, is to provide a unique gateway to the client applications of our system. The fact that our services are split into small microservices apps that shouldn’t be visible to users otherwise it may result in substantial development/maintenance efforts. Also there are scenarios when whole ecosystem network traffic may be passing through a single point which could impact the performance of the cluster.

@@SpringBootApplication @EnableHystrix public class APIGatewayApplication {

public static void main(String[] args) {
	SpringApplication.run(APIGatewayApplication.class, args);
}
}

API Cloud Gateway Open application.yml

server: port: 8888

eureka: client: serviceUrl: defaultZone: http://localhost:8761/eureka

spring: application: name: apigetway

Micro Service Spring
Micro Services endpoints :

( POST )- /api/../add** => create data ( PUT ) - /api/../update**/{id} => Update ( DELETE ) - /api/../delete/{id} => delete data ( GET ) - /api/../get** => show data ( GET ) - /api/../get/{id} => show unique data




ReactJS
The React. js framework is an open-source JavaScript framework and library developed by Facebook. It's used for building interactive user interfaces and web applications quickly and efficiently with significantly less code than you would with vanilla JavaScript.

