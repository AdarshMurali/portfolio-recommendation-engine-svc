#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/portfolio-recommendation-engine-0.0.1-SNAPSHOT.jar /usr/local/lib/portfolio-recommendation-engine.jar
EXPOSE 8080
ENV PROFILE prod
ENV SPRING_DATASOURCE_URL jdbc:sqlserver://portfoliorecomendation.database.windows.net;encrypt=true;trustServerCertificate=true;databaseName=Portfolio
ENV SPRING_DATASOURCE_USERNAME PortRecom
ENV SPRING_DATASOURCE_PASSWORD Portfolio@007
ENV SPRING_DATASOURCE_DRIVERCLASSNAME com.microsoft.sqlserver.jdbc.SQLServerDriver
ENTRYPOINT ["java","-jar","/usr/local/lib/portfolio-recommendation-engine.jar"]


# docker buildx build . --builder "$(docker buildx create --driver-opt env.BUILDKIT_STEP_LOG_MAX_SIZE=10000000 --driver-opt env.BUILDKIT_STEP_LOG_MAX_SPEED=10000000)"
