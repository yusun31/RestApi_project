FROM openjdk:8
EXPOSE 8087
ADD target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
ENTRYPOINT ["java","-jar","/myspringboot-app-reactjs-backend.jar","--DB=mysql-svc"]