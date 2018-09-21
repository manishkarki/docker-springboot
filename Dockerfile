FROM openjdk:8
ADD target/docker-springboot.jar docker-springboot.jar
VOLUME /tmp
ENTRYPOINT ["java","-jar","docker-springboot.jar"]
