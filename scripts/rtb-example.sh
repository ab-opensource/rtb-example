#!/bin/sh

DIR=$(cd `dirname $0` && pwd)

SERVER=127.0.0.1
PORT=8888
URL="/rtb"

java -classpath "$DIR/rtb-example.jar" com.adbrite.rtb.example.RTBServer


