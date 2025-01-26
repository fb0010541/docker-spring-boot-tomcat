# 使用 Dockerfile 建立 Tomcat image 並部署 Spring boot
## 使用 Dockerfile 打包 Spring boot War 
* maven 影像使用 https://hub.docker.com/_/maven
* 使用 spring initializr 建立 Spring boot 專案
* spring initializr 位置 https://start.spring.io/
* dependencies 需引用 Spring Web，並建立 test RestController
## 使用 Dockerfile 打包複製 war 進 Tomcat image 並啟動
* tomcat 影像使用 https://hub.docker.com/_/tomcat/tags
