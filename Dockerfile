FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/SpringSecurityJWT-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT [ "java", "-jar", "/api.jar" ]