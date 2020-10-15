#!/bin/bash

java -jar \
/usr/libexec/sdw/sensor-data-warehouse.jar \
--spring.config.additional-location=/etc/sdw/sdw.yaml
