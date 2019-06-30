#!/bin/bash

# if the custom starter is used it can be executed without manipulating JAVA_HOME, PATH, etc.

if [ ! -d target/customJRE ]
then
    echo "ERROR: the custom JRE was not yet created"
    exit 1
fi

target/customJRE/bin/java -version 2>&1 | head -1
target/customJRE/bin/MainDemo
