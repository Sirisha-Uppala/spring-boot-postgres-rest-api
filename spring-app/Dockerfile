FROM openjdk:8-jdk-alpine
FROM maven

RUN mkdir -p /work/jar /work/java/test1 \
 && microdnf install yum \
 && yum install iputils procps vi -y

COPY ./jar/spring-app.jar /work/jar/
COPY ./entrypoint.sh /work/java/scripts/
ADD test1 /work/java/test1

#ENTRYPOINT ["entrypoint.sh"]
CMD tail -f /dev/null
