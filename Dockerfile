FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} alphabank.jar
ENTRYPOINT ["java","-jar","/alphabank.jar"]
