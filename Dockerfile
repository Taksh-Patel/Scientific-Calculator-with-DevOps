FROM openjdk:8
COPY ./target/Scientific-Calculator-with-DevOps-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "Scientific-Calculator-with-DevOps-1.0-SNAPSHOT-jar-with-dependencies.jar"]