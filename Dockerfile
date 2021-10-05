FROM adoptopenjdk:11.0.11_9-jre-hotspot-focal
WORKDIR /app
EXPOSE 7000
COPY build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]