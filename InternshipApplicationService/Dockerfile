#FROM adoptopenjdk/openjdk14:alpine-jre
#ADD target/*.jar app.jar
#ENV JAVA_OPTS=""
#EXPOSE 9099
#ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /app.jar"]

FROM maven:3.6.3-openjdk-16-slim AS build

ENV DB_HOST=stagi_db \
     DB_USERNAME=root \
     DB_PASSWORD=1234 \
     ZIPKIN=stage_zipkin_1

COPY ./ /usr/local/

WORKDIR /usr/local/

RUN mvn -Dmaven.test.skip=true clean package


FROM tomcat:8
#FROM adoptopenjdk/openjdk14:alpine-jre
COPY --from=build /usr/local/target/InternshipApplicationService-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/InternshipApplicationService-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
EXPOSE 9099

#CMD ["catalina.sh", "run"]
# ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom", "-jar","/usr/local/tomcat/webapps/UserService-0.0.1-SNAPSHOT.jar"]

#ENTRYPOINT ["java ", "-jar","/usr/local/tomcat/webapps/InternshipApplicationService-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /usr/local/tomcat/webapps/InternshipApplicationService-0.0.1-SNAPSHOT.jar"]
