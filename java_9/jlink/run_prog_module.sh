#!/bin/bash

case ${1} in
    9)
        export JAVA_HOME=~/bin/jdk9
        export TARGET_DIR=target/jpms.demo
        ;;
    10)
        export JAVA_HOME=~/bin/jdk10
        export TARGET_DIR=target/classes
        ;;
    *)
        echo "missed the Java version to use..."
        echo "usage: $0 [9|10]"
        exit 1
        ;;
esac

export PATH=${JAVA_HOME}/bin:${PATH}

echo "### compile project"
mvn -q compile

echo "### execute Main class with module path"
java --module-path ${TARGET_DIR} --module jpms.demo/jug.trier.jpms.demo.Main
