#!/bin/bash

# Java 8, 9, ..., the format differ
# Java 8 uses Parallel GC as default
# Java 9 uses G1 GC as default and unified logging
# java -cp target/classes/ -verbose:gc -Xmx21m jep271.Garbage

# Java 8, 9, ..., the format differ bcause Java 9 uses unified logging
# java -cp target/classes/ -XX:+UseG1GC -XX:+PrintGC -Xmx21m jep271.Garbage

# Java < 9, as option PrintGCTimeStamps has been removed
# java -cp target/classes/ -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xmx21m jep271.Garbage

# Java >= 9, as option -Xlog was introduced with Java 9
# java -cp target/classes/ -Xlog:gc -Xmx21m jep271.Garbage
