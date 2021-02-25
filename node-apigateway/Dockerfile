FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-apigateway-1.0.0.jar node-apigateway-1.0.0.jar
EXPOSE 80
ENV JPARAM="-Xmn256m -Xmx256m"
ENTRYPOINT [ "sh","-c","java ${JPARAM} -DPORT=80 -DDISCOVERY=http://discovery:5555/eureka/ -jar node-apigateway-1.0.0.jar" ]
