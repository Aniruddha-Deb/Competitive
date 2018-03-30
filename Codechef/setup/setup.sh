#!/bin/bash

name="$1"

cd /Users/Sensei/Projects/[Educational]/Competitive/Codechef/problems
mkdir $name
cd $name
touch "in.txt"
touch "out.txt"
touch "comp.txt"

cp "../../setup/config.java" "$name.java"