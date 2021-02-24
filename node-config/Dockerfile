FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-config-1.0.0.jar node-config-1.0.0.jar
EXPOSE 80
ENV JPARAM="-Xmn256m -Xmx256m"
ENTRYPOINT [ "sh","-c","java ${JPARAM} -DPORT=80 -jar node-config-1.0.0.jar" ]
