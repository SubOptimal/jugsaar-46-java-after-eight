#!/bin/bash

case ${1} in
	9) 
	   	export JAVA_HOME=~/bin/jdk9
		export JAVA_VERSION=9
		;;
	8)
	   	export JAVA_HOME=~/bin/jdk8
		export JAVA_VERSION=1.8
		;;
	*)
        echo "missed the Java version to use..."
        echo "usage: $0 [8|9]"
        exit 1
		;;
esac

export PATH=${JAVA_HOME}/bin:${PATH}

mvn -q clean compile exec:exec -Dexec.executable=java -Djava.version=${JAVA_VERSION} -Dexec.args="-cp %classpath ${JVM_OPTS} jep280.DefaultConcat"

# shows different implementation of the default concatenation "oneString + anotherString"
# Java 8 StringBuilder with append()
# Java 9 
javap -cp target/classes -c jep280.DefaultConcat