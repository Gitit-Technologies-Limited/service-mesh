FROM maven:3.8.7-openjdk-18 as builder

ENV HOME=/opt/app

RUN mkdir $HOME

WORKDIR $HOME

ADD . .

RUN mvn clean package -DskipTests

RUN ls -l $HOME/target

# Use an official OpenJDK runtime image as a parent image for the runtime stage
FROM amazoncorretto:21.0.2

ENV HOME=/opt/app

# Set the working directory in the container
WORKDIR $HOME

# Copy the application JAR from the build stage into the container
COPY --from=builder $HOME/target/event-bus-1.0-SNAPSHOT.jar $HOME/event-bus-1.0-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "event-bus-1.0-SNAPSHOT.jar"]