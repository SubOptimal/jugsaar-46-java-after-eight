#!/bin/bash

mvn compile

echo "### show module dependecies in verbose mode"
jdeps --module-path target/classes/ -verbose --module jpms.demo

