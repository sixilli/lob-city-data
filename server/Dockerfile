FROM maven:3.8.7-eclipse-temurin-19-alpine
ENV firestore-env=prod
ARG creds
ENV CREDS=$creds
WORKDIR /web-server
COPY . .
EXPOSE 8080
RUN mvn package -Pnative
CMD ["java", "-jar", "target/lobcitydata-0.0.1-SNAPSHOT.jar"]