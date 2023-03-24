FROM openjdk:11-oracle
EXPOSE 1222
ADD target/department-docker.jar  department-docker.jar
ENTRYPOINT ["java","-jar","/department-docker.jar"]