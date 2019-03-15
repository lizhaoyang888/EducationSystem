FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN  mkdir -p /Users/lizhaoyang/docker/spring-cloud-zuul/
ADD  @project.build.finalName@.jar /Users/lizhaoyang/docker/spring-cloud-zuul/
ADD  run.sh run.sh
RUN  chmod +x run.sh
CMD  ./run.sh
