FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} test.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test.jar"]