FROM openjdk:8
EXPOSE 8087
ADD target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
ENTRYPOINT ["java","-jar","/springboot-reactjs-backend.jar","--spring.profiles.active=prod","--DB=mysql-svc"]