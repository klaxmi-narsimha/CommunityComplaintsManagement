
# Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

ARG DB_USERNAME
ARG DB_PASSWORD
ARG DB_URL

RUN printf 'DB_USERNAME=%s\nDB_PASSWORD=%s\nDB_URL=%s\n' \
    "$DB_USERNAME" \
    "$DB_PASSWORD" \
    "$DB_URL" \
    > src/main/resources/application.properties

RUN mvn clean package -DskipTests


# Runtime stage - Tomcat 11

FROM tomcat:11.0-jdk21-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/Community.war \
    /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]