#!/usr/bin bash

javac $(find src -name "*.java") -d bin/
jar cvfe SpeedTime.jar main.Main -C bin .