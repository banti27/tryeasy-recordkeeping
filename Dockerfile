FROM openjdk:17
RUN chmod +x gradlew
RUN ./gradlew clean build
COPY build/libs/tryeasy-recordkeeping-0.0.1-SNAPSHOT.jar tryeasy-recordkeeping.jar
ENTRYPOINT ["java","-jar","tryeasy-recordkeeping.jar"]
