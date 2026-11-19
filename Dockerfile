FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Create the resources directory and an empty properties file
RUN mkdir -p src/main/resources && touch src/main/resources/application.properties

RUN mvn clean package -DskipTests


# Runtime stage - Tomcat 11

FROM tomcat:11.0-jdk21-temurin

# Remove default applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Deploy Spring MVC application
COPY --from=build /app/target/Community.war \
    /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]