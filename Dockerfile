FROM openjdk:8-jdk-alpine
EXPOSE 80
ADD /target/transcor-poc-0.0.1.jar nyc-taxi.jar
ENTRYPOINT ["java", "-jar","/nyc-taxi.jar"]