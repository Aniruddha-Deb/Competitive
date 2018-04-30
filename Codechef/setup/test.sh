#!/bin/bash

cd "$1"

javac Solution.java
java Solution < "in.txt"