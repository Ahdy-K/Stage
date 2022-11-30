#FROM maven:3.6.3-openjdk-16-slim AS build

##FROM adoptopenjdk/openjdk14:alpine-jre
#ADD target/UserService-0.0.1-SNAPSHOT.jar .

#ENV DB_HOST=db \
 #    DB_USERNAME=root \
  #   DB_PASSWORD=1234
#COPY ./ /usr/local/userservice
#WORKDIR /usr/local/userservice/
#RUN mvn -Dmaven.test.skip=true clean package

##FROM adoptopenjdk/openjdk14:alpine-jre
##COPY --from=build /usr/local/userservice/UserService-0.0.1-SNAPSHOT.jar /usr/local/userservice/UserService-0.0.1-SNAPSHOT.jar
#ENV JAVA_OPTS=""
#EXPOSE 9090
##ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /app.jar"]
#ENTRYPOINT ["sh","-c", "java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar UserService-0.0.1-SNAPSHOT.jar" ]

# TRY a MNIMALIST IMG without env
#FROM openjdk:11
#COPY target/UserService-0.0.1-SNAPSHOT.jar UserService-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar","/UserService-0.0.1-SNAPSHOT.jar"]
####
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
COPY --from=build /usr/local/target/UserService-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/UserService-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
EXPOSE 9090

#CMD ["catalina.sh", "run"]
# ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom", "-jar","/usr/local/tomcat/webapps/UserService-0.0.1-SNAPSHOT.jar"]

#ENTRYPOINT ["java", "-jar","/usr/local/tomcat/webapps/UserService-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /usr/local/tomcat/webapps/UserService-0.0.1-SNAPSHOT.jar"]
