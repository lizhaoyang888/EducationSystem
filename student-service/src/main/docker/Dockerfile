FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN  mkdir -p /Users/lizhaoyang/docker/student-service/
ADD  @project.build.finalName@.jar /Users/lizhaoyang/docker/student-service/
ADD  run.sh run.sh
RUN  chmod +x run.sh
CMD  ./run.sh
