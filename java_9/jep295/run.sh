#!/bin/bash

java -XX:AOTLibrary=./libHelloWorld.so -XX:+PrintAOT HelloWorld
