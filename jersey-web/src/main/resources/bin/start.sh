#!/usr/bin/env bash
JAVA_OPT="-server -d64 -Xms500M -Xmx500M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./gc.log"
nohup java $JAVA_OPT -cp ../conf:../lib/* org.springframework.boot.loader.JarLauncher &> stdout.log &