# 使用 Dockerfile 建立 Tomcat image 並部署 Spring boot
## 環境版本
* maven 3.9.9
* Spring boot 3.4.2 (搭配 JDK, Tomcat 最低版本如下)
* JDK 17
* Tomcat 10
## [Dockerfile](http://192.168.50.30:8080/benson/docker-spring-boot-tomcat/src/branch/main/Dockerfile)
## 使用 Dockerfile 打包 Spring boot War 
* maven 影像使用 https://hub.docker.com/_/maven
* 使用 spring initializr 建立 Spring boot 專案
* spring initializr 位置 https://start.spring.io/
* dependencies 需引用 Spring Web，並建立 test RestController
## 使用 Dockerfile 打包複製 war 進 Tomcat image 並啟動
* tomcat 影像使用 https://hub.docker.com/_/tomcat/tags
## 建立影像
* sudo docker build -t mytomcat:latest .
## 啟動容器
* sudo docker run -p 8080:8080 --rm --name my-running-tomcat mytomcat:latest