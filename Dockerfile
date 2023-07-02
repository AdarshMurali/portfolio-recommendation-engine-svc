FROM openjdk:8-jdk-alpine
LABEL <h13a005@gmail.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/portfolio-recommendation-engine-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]