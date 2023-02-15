# First stage: build the Quarkus application
FROM maven:3.8.4-jdk-11 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /build/src/
RUN mvn package -Dquarkus.package.type=uber-jar
RUN ls /build

# Second stage: create the Docker image
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S quarkus && adduser -S quarkus -G quarkus
RUN mkdir /app && chown quarkus:quarkus /app
USER quarkus
WORKDIR /app
COPY --from=build /build/target/*-runner.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
