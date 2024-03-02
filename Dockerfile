FROM openjdk:21-jdk

COPY target/BillingFile-jar.jar .

EXPOSE 8081

ENTRYPOINT [ "java","-jar","BillingFile-jar.jar" ]