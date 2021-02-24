FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-discovery-1.0.0.jar xyz.jar
EXPOSE 5555
ENV JPARAM="-Xmn256m -Xmx256m"
ENTRYPOINT [ "sh","-c","java ${JPARAM} -jar xyz.jar" ]
