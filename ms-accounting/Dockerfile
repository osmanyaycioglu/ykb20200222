FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/ms-accounting-1.0.0.jar ms-accounting-1.0.0.jar
EXPOSE 80
ENV JPARAM="-Xmn256m -Xmx256m"
ENTRYPOINT [ "sh","-c","java ${JPARAM} -DPORT=80 -DCONFIG=http://config -jar ms-accounting-1.0.0.jar" ]
