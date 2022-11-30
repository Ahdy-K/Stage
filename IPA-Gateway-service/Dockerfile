FROM adoptopenjdk/openjdk14:alpine-jre
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8081
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.edg=file:/dev/urandom -jar /app.jar"]
