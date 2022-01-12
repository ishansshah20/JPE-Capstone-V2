#FROM maven:3.6.0-jdk-11-slim AS build
#WORKDIR /app
#COPY . .
#RUN mvn -f /app/pom.xml clean package
#
#FROM openjdk:15
#WORKDIR /app
#EXPOSE 80
#COPY --from=build /app/target/jpe-app.jar .
#ENTRYPOINT ["java", "-jar", "jpe-app.jar"]

#-------------------------------------
#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#EXPOSE 80
#ADD target/*.jar JPECapstone.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /JPECapstone.jar" ]

#-------------------------------------
FROM maven:3.6.1-jdk-8-slim AS build
ARG DB_SERVER=${DB_SERVER}
ARG DB_USERNAME=${DB_USERNAME}
ARG DB_PASSWORD=${DB_PASSWORD}
ARG DB_NAME=${DB_NAME}
ENV DB_SERVER=${DB_SERVER}
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}
ENV DB_NAME=${DB_NAME}
RUN echo "hello world $DB_SERVER"
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM openjdk:8-alpine
COPY --from=build /workspace/target/*.jar jpe-app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","jpe-app.jar"]






