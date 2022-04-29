FROM openjdk:8
EXPOSE 8087
ADD target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
ENTRYPOINT ["java","-jar","/myspringboot-app-0.0.1-SNAPSHOT.jar","--DB=mysql-svc"]