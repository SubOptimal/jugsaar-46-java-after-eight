#!/bin/bash

if [ ! -d target/customJRE ]
then
    echo "ERROR: the custom JRE was not yet created"
    exit 1
fi

export JAVA_HOME=$(pwd)/target/customJRE
export PATH=${JAVA_HOME}/bin:${PATH}

java -version 2>&1 | head -1

# Java 9 only if the custom JRE is build properly (e.g with workaround for JDK-8192986, see: run_jlink.sh)
# otherwise it fails with:
#     Error: Could not find or load main class jug.trier.jpms.demo.Main in module jpms.demo
#
# >= Java 10
java --module jpms.demo/jug.trier.jpms.demo.Main
