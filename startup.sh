#!/bin/bash

java -jar \
./target/sensor-data-warehouse-1.0.0.jar \
--spring.config.additional-location=./src/main/docker/sdw.yaml
