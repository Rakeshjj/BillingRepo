FROM openjdk:17-jdk

COPY target/BillingFile-jar.jar .

EXPOSE 8082

ENTRYPOINT [ "java","-jar","BillingFile-jar.jar" ]
