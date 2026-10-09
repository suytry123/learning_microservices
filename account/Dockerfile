#Start with base image containing java runtime
FROM eclipse-temurin:17-jdk AS build

# Information of owner or maintainer of image
LABEL maintainer="suytrybank"

# Add the application's jar to the container
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/account-0.0.1-SNAPSHOT.jar"]