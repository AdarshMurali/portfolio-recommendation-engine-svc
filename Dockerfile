FROM openjdk:8
LABEL h13a005 <h13a005@gmail.com>
VOLUME /tmp
EXPOSE 8080

ENV PROFILE prod
ENV SPRING_DATASOURCE_URL jdbc:sqlserver://portfoliorecomendation.database.windows.net;encrypt=true;trustServerCertificate=true;databaseName=Portfolio
ENV SPRING_DATASOURCE_USERNAME PortRecom
ENV SPRING_DATASOURCE_PASSWORD Portfolio@007
ENV SPRING_DATASOURCE_DRIVERCLASSNAME com.microsoft.sqlserver.jdbc.SQLServerDriver

ARG JAR_FILE=target/portfolio-recommendation-engine-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]