# 使用 docker 在 maven 容器中打包 Spring boot 應用程式並部署在 Tomcat 容器中
## 環境版本
* maven 3.9.9
* Spring boot 3.4.2 (搭配 JDK, Tomcat 最低版本如下)
* JDK 17
* Tomcat 10
## demo 流程
使用 docker 指令建立 image 與啟動 container 後驗證 web 服務是否正常 
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
> line 1-4 : 使用 maven 容器打包 Spring boot war 檔，
> maven image 來源請參考 [dockerhub maven](https://hub.docker.com/_/maven)  
> line 5-7 : 將 war 部署到 Tomcat 中，
> Tomcat image 來源請參考 [dockerhub tomcat]https://hub.docker.com/_/tomcat/tags)
### 建立影像
```
sudo docker build -t mytomcat:latest .
```
### 啟動容器
```
sudo docker run -p 8080:8080 --rm --name my-running-tomcat mytomcat:latest
```
> 測試驗證點選 http://localhost:8080/docker-spring-boot-tomcat/hello 驗證結果
## 補充說明 Spring boot 建置步驟
* 使用 spring initializr 建立 Spring boot 專案
* spring initializr 位置 https://start.spring.io/
* dependencies 需引用 Spring Web，並建立 test RestController
