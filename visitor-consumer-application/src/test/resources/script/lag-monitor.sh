#!/bin/bash

while true; do
    kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group visitor-count-increase-consumer --describe
done
