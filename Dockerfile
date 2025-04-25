FROM openjdk:21

WORKDIR /app

COPY /target/journalApp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8088

ENTRYPOINT ["java","-jar","app.jar"]