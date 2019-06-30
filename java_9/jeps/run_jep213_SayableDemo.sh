#!/bin/bash

export JAVA_HOME=~/bin/jdk9
export PATH=${JAVA_HOME}/bin:${PATH}

javac -d target/classes src/main/java/jep213/Say*.java
java -cp target/classes jep213.SayableDemo

