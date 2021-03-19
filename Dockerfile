FROM openjdk:11-jre-slim

COPY ./target/sensor-data-warehouse-1.4.0.jar /usr/libexec/sdw/sensor-data-warehouse.jar
COPY src/main/docker /etc/sdw

RUN chmod +x /etc/sdw/startup.sh

EXPOSE 8080

ENTRYPOINT ["/etc/sdw/startup.sh"]
