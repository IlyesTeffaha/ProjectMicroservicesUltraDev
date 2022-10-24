FROM openjdk:17-oracle
EXPOSE 8090
ADD /target/candidate-0.0.1-SNAPSHOT.jar candidate.jar
ENTRYPOINT ["java","-jar","candidate.jar"]
