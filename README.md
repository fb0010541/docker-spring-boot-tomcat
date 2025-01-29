# 使用 Dockerfile 建立 Tomcat image 並部署 Spring boot
## 環境版本
* maven 3.9.9
* Spring boot 3.4.2 (搭配 JDK, Tomcat 最低版本如下)
* JDK 17
* Tomcat 10
## Dockerfile
```
FROM maven:3.9.9-amazoncorretto-17-alpine AS builder
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean package
FROM tomcat:10.1.34-jre17-temurin-noble
COPY --from=builder ./target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]
```
### 使用 maven 容器打包 Spring boot War 
* maven 影像使用 https://hub.docker.com/_/maven
### 將打包後的 war 複製進 Tomcat image 並啟動
* tomcat 影像使用 https://hub.docker.com/_/tomcat/tags
### 建立影像
```
sudo docker build -t mytomcat:latest .
```
### 啟動容器
```
sudo docker run -p 8080:8080 --rm --name my-running-tomcat mytomcat:latest
```
* 測試驗證點選 http://localhost:8080/docker-spring-boot-tomcat/hello 驗證結果
## 補充說明 Spring boot 建置步驟
* 使用 spring initializr 建立 Spring boot 專案
* spring initializr 位置 https://start.spring.io/
* dependencies 需引用 Spring Web，並建立 test RestController
