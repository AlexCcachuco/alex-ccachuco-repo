FROM openjdk:17-jdk-alpine
COPY "./target/block12-kakfa-Consumer-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]