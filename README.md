# spring-with-rabbitmq
A sample repo with an implementation of Spring Boot 3 and RabbitMQ

Execute the following command to run the RabbitMQ server:<br/>
```docker-compose up -d my-rabbit```
<br/>
<br/>Execute the following command to install the application:<br/> 
```mvn clean install```
<br/><br/>Execute the following command to run the Spring Boot application:<br/>
```mvn spring-boot:run```

Execute the following command to run the Spring Boot application in a Docker container:
```
    docker build -t spring-with-rabbitmq-app .  
    docker run -p 8080:8080 spring-with-rabbitmq 
```
