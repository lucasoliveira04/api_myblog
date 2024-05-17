FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 3000

COPY --from=build /target/api_myblog-0.0.1.jar app.jar

ENV DATABASE_URL=jdbc:postgresql://dpg-cp2mak21hbls73813ms0-a:5432/authdb_sjy0
ENV DATABASE_USERNAME=admin
ENV DATABASE_PASSWORD=njdiayzoN6zb8tcC88AeX50DoiZB8a89

ENTRYPOINT ["java", "-jar", "app.jar"]