#!/bin/bash

mvn compile

echo "### show module dependencies as summary"
jdeps --module-path target/classes/ -summary --module jpms.demo

