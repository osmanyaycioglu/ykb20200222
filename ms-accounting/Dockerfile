FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/ms-accounting-1.0.0.jar ms-accounting-1.0.0.jar
EXPOSE 80
ENV JPARAM="-Xmn256m -Xmx256m"
ENTRYPOINT [ "sh","-c","java ${JPARAM} -DCONFIG=http://config -DDISCOVERY=http://discovery:5555/eureka/ -DPORT=80 -jar ms-accounting-1.0.0.jar" ]
