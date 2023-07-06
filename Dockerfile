FROM maven:3.9.2-eclipse-temurin AS builder

WORKDIR /opt/events-service

ADD pom.xml .

RUN mvn dependency:resolve

ADD src src

RUN mvn clean install

FROM eclipse-temurin AS release

WORKDIR /opt/events-service

COPY --from=builder /opt/events-service/target/events-service-0.0.1-SNAPSHOT.jar events-service.jar

ENTRYPOINT ["java", "-jar", "events-service.jar"]