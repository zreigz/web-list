#
# Docker image with web-log application
#
FROM williamyeh/java8
MAINTAINER Lukasz Zajaczkowski "zreigz@gmail.com"

WORKDIR /home
COPY target/web-list-0.0.1-SNAPSHOT.jar web-list.jar
COPY start.sh start.sh
COPY configuration.yml configuration.yml
ENTRYPOINT ["/home/start.sh"]
