FROM maven:3.9.9-amazoncorretto-17-alpine AS builder
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean package
FROM tomcat:10.1.34-jre17-temurin-noble
COPY --from=builder ./target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]