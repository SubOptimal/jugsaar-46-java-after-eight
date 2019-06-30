#!/bin/bash

case ${1} in
	9) 
	   	export JAVA_HOME=~/bin/jdk9
		;;
	8)
	   	export JAVA_HOME=~/bin/jdk8
		;;
	*)
		echo "missed the Java version to use..."
        echo "usage: $0 [8|9]"
		exit 1
		;;
esac

export PATH=${JAVA_HOME}/bin:${PATH}

mvn -q compile exec:exec -Dexec.executable=java -Dexec.args="-cp %classpath jep223.JavaVersion"
