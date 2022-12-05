FROM maven:3.6.3-openjdk-16-slim AS build
COPY ./ /usr/local/
WORKDIR /usr/local/
RUN mvn -Dmaven.test.skip=true clean package

FROM tomcat:8
#FROM adoptopenjdk/openjdk14:alpine-jre
COPY --from=build /usr/local/target/IPA-Gateway-service-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/IPA-Gateway-service-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
EXPOSE 8881
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /usr/local/tomcat/webapps/IPA-Gateway-service-0.0.1-SNAPSHOT.jar"]
