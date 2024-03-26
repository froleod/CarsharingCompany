FROM maven:3.8.6 as builder
WORKDIR opt/app
COPY mvnw pom.xml ./
RUN mvn clean install -DskipTests


FROM openjdk:17
LABEL authors="froleod"
WORKDIR opt/app

#ARG APP_JAR=*.jar

#COPY ${APP_JAR} app.jar

COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar

ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]

EXPOSE 8080
