FROM openjdk:8
EXPOSE 8080
ADD target/myspringboot-app-0.0.1-SNAPSHOT.jar myspringboot-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/myspringboot-app-0.0.1-SNAPSHOT.jar","--DB=mysql-svc"]