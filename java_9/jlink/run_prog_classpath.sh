#!/bin/bash

export JAVA_HOME=~/bin/jdk9
export PATH=${JAVA_HOME}/bin:${PATH}

java -classpath target/classes jug.trier.jpms.demo.Main
