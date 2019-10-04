FROM openjdk:alpine
ADD target/target/userservice-0.0.1-SNAPSHOT.jar /app.jar
CMD java -jar /app.jar
