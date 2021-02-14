FROM openjdk:8u201-jre-alpine3.9
USER root
MAINTAINER Mohan Vamsi <mohanvamsi75@gmail.com>

#Install dependencies
RUN apk update && apk add bash curl

#Copying artifacts
COPY target/*.jar /app/
COPY entry-point.sh /app

RUN chmod +x /app/entry-point.sh

WORKDIR /app

CMD ["./entry-point.sh"]