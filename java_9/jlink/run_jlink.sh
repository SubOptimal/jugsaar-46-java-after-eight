#!/bin/bash

rm -rf target/customJRE

case ${1} in
    9)
        export JAVA_HOME=~/bin/jdk9
        export PATH=${JAVA_HOME}/bin:${PATH}
        echo "jlink $(jlink --version)"
        mvn clean compile

        # workaround for: https://bugs.openjdk.java.net/browse/JDK-8192986
        # otherwise it fails with:
        #     Error: jdk.tools.jlink.plugin.PluginException: java.io.IOException: module-info.class not found for jpms.demo module
        mv target/classes target/jpms.demo

        # JDK jmods must be added explicitly
        # otherwise it fails with:
        #     Error: Module java.base not found, required by jpms.demo
        jlink --module-path ${JAVA_HOME}/jmods:target/jpms.demo \
        --add-modules jpms.demo \
        --launcher MainDemo=jpms.demo/jug.trier.jpms.demo.Main \
        --output target/customJRE
        ;;
    10)
        export JAVA_HOME=~/bin/jdk10
        export PATH=${JAVA_HOME}/bin:${PATH}
        echo "jlink $(jlink --version)"
        mvn clean compile

        jlink --module-path target/classes \
        --add-modules jpms.demo \
        --launcher MainDemo=jpms.demo/jug.trier.jpms.demo.Main \
        --output target/customJRE
        ;;
    *)
        echo "missed the Java version to use..."
        echo "usage: $0 [9|10]"
        exit 1
        ;;
esac
