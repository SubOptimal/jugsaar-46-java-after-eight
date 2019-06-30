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

javac -d target/classes src/main/java/jep252/Locales.java
java -cp target/classes jep252.Locales
