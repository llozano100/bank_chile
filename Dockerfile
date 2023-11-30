FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=target/ms-user-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app/spring-boot-app.jar
ENTRYPOINT ["java","-jar","app/spring-boot-app.jar"]